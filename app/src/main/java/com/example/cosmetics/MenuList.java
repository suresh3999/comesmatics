package com.example.cosmetics;

public class MenuList {

    private String productTitle;
    private String productPrice;
    private String productDiscountPrice;
    private String productPercentage;
    private String productImage;
    private String proNoOfPurchase;
    private String proQty;
    private String currencySymbol;
    private String currencyCode;






    public MenuList(String productTitle, String productPrice, String productDiscountPrice, String productPercentage, String productImage, String currencySymbol, String proQty, String currencyCode,String proNoOfPurchase) {


        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productDiscountPrice = productDiscountPrice;
        this.productPercentage = productPercentage;
        this.productImage = productImage;
        this.proNoOfPurchase = proNoOfPurchase;
        this.proQty = proQty;
        this.currencySymbol = currencySymbol;

    }


    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDiscountPrice() {
        return productDiscountPrice;
    }

    public void setProductDiscountPrice(String productDiscountPrice) {
        this.productDiscountPrice = productDiscountPrice;
    }

    public String getProductPercentage() {
        return productPercentage;
    }

    public void setProductPercentage(String productPercentage) {
        this.productPercentage = productPercentage;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProNoOfPurchase() {
        return proNoOfPurchase;
    }

    public void setProNoOfPurchase(String proNoOfPurchase) {
        this.proNoOfPurchase = proNoOfPurchase;
    }

    public String getProQty() {
        return proQty;
    }

    public void setProQty(String proQty) {
        this.proQty = proQty;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
