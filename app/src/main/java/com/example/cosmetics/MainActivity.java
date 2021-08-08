package com.example.cosmetics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<MenuList> menuLists;
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
     /*   HorizontalLayout
                = new LinearLayoutManager(
                Homepage1.this,
                LinearLayoutManager.HORIZONTAL,
                false);*/
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        // Set layout manager.
        recyclerView.setLayoutManager(gridLayoutManager);

        //   recyclerView.setLayoutManager(HorizontalLayout,2);


        menuLists = new ArrayList<>();
        cosmetics();

        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }

    private void cosmetics() {

        {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, Api.URL_MENU_LIST,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {


                            try {

                                JSONObject jsonObject = new JSONObject(response);


                                //  code = status.getString("code");
                                JSONArray cos = jsonObject.getJSONArray("data");
                                for (int i = 0; i < cos.length(); i++) {

                                    JSONObject jo = cos.getJSONObject(i);
                                    MenuList fetch1 = new MenuList(jo.getString("productTitle"), jo.getString("productPrice"), jo.getString("productDiscountPrice"), jo.getString("productPercentage"), jo.getString("productImage"), jo.getString("proNoOfPurchase"), jo.getString("proQty"), jo.getString("currencySymbol"), jo.getString("currencyCode"));
                                    menuLists.add(fetch1);

                                }
                                adapter = new MenuAdapter(menuLists, getApplicationContext());
                                recyclerView.setAdapter(adapter);

                            } catch (
                                    JSONException e) {
                                e.printStackTrace();
                            }


                        }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                }
            }) {

                @Override
                public byte[] getBody() throws AuthFailureError {
                    String str = "{\"availability\":\"" + "1" + "\",\"cusId\":\"" + "91" + "\",\"lang\":\"" + "en" + "\"" +
                            ",\"pageNo\":\"" + "1" + "\",\"sortOrderBy\":\"" + "4" + "\",\"discount\":\"" + "" + "\"" +
                            ",\"mainCategoryId\":\"" + "" + "\",\"priceMax\":\"" + "" + "\"" +
                            ",\"priceMin\":\"" + "" + "\",\"secCategoryId\":\"" + "" + "\",\"subCategoryId\":\"" + "" + "\",\"title\":\"" + "" + "\"}";
                    return str.getBytes();
                }

                ;

                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<>();


                    return headers;
                }

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();

                    return params;
                }
            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    20000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(stringRequest);

        }
        }
        @Override
        public void onWindowFocusChanged(boolean hasFocus) {
            super.onWindowFocusChanged(hasFocus);
            if (hasFocus) {
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
    }

