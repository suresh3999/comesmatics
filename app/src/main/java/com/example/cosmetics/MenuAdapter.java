package com.example.cosmetics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by EKENE on 7/23/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {



    // we define a list from the DevelopersList java class

    private List<MenuList> menuLists;
    private Context context;

    public MenuAdapter(List<MenuList> menuLists, Context context) {

        // generate constructors to initialise the List and Context objects

        this.menuLists = menuLists;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method will be called whenever our ViewHolder is created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // this method will bind the data to the ViewHolder from whence it'll be shown to other Views

        final MenuList menuList = menuLists.get(position);
        holder.prodeuct_name.setText(menuList.getProductTitle());
        holder.currencySymbol.setText(menuList.getCurrencySymbol());
        holder.currencyCode.setText(menuList.getCurrencyCode());
        holder.productPrice.setText(menuList.getProductPrice());
        holder.productDiscountPrice.setText(menuList.getProductDiscountPrice());

        Picasso.with(context)
                .load(menuList.getProductImage())
                .into(holder.imge_url);


    }

    @Override


    public int getItemCount() {
        return menuLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imge_url;
        public TextView prodeuct_name,currencyCode,currencySymbol,productPercentage;
        public TextView productPrice;
        public TextView productDiscountPrice;


        public ViewHolder(View itemView) {
            super(itemView);


            imge_url = (ImageView) itemView.findViewById(R.id.pro_img);
            prodeuct_name = (TextView) itemView.findViewById(R.id.pro_name);
            productPrice = (TextView) itemView.findViewById(R.id.productPrice);
            productDiscountPrice = (TextView) itemView.findViewById(R.id.productDiscountPrice);
           // productPercentage = (TextView) itemView.findViewById(R.id.productPercentage);
            currencySymbol = (TextView) itemView.findViewById(R.id.currencySymbol);
            currencyCode = (TextView) itemView.findViewById(R.id.currencyCode1);




        }

    }
}
