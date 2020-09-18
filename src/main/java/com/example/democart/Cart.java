package com.example.democart;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
@Id

    private int id;
    private String products;
    private String productCode;
    private String couponCode;
    private int totalprice;
    private int discountedprice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public int getDiscountedprice() {
        return discountedprice;
    }

    public void setDiscountedprice(int discountedprice) {
        this.discountedprice = discountedprice;
    }
}
