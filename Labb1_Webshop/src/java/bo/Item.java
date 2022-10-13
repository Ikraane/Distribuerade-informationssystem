package bo;

import db.ItemDB;

import java.util.Collection;
import java.util.Collections;

public class Item {

    private int itemId;
    private String name;
    private String imagePath;
    private int price;

    static public Collection searchItems(String group){
        return ItemDB.searchItems(group);
    }

    protected Item(int itemId, String name, String imagePath, int price) {
        this.itemId = itemId;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
