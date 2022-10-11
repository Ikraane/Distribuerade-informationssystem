package com.test.beans;

import com.test.dao.DBUser;
import com.test.dao.ProductDB;

import java.util.List;

public class ShoppingCart {
    private DBUser user;
    private List<ProductDB> productsInCart;

    public ShoppingCart(DBUser user, List<ProductDB> productsInCart) {
        this.user = user;
        this.productsInCart = productsInCart;
    }

    public DBUser getUser() {
        return user;
    }

    public void setUser(DBUser user) {
        this.user = user;
    }

    public List<ProductDB> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<ProductDB> productsInCart) {
        this.productsInCart = productsInCart;
    }
}
