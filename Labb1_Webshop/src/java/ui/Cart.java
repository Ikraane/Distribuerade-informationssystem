package ui;

import java.util.AbstractQueue;
import java.util.ArrayList;

public class Cart {

    private static ArrayList<ItemInfo> cart = null;

    public Cart() {
        if(cart == null){
            cart = new ArrayList<>();
        }
    }

    public static ArrayList<ItemInfo> getCart() {
        return cart;
    }

    public void addToCart(ItemInfo itemInfo){
        cart.add(itemInfo);
    }

    @Override
    public String toString() {

        String info = "";
        for(int i = 0; i <cart.size(); i++){
            info += cart.get(i).getName();
        }
        return info;
    }
}
