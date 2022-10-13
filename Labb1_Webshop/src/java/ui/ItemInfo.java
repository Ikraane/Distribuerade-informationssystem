package ui;

public class ItemInfo {
    private String name;
    private String imagePath;
    private int price;

    public ItemInfo(String name, String imagePath, int price) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ," + price;
    }
}
