package bo;

import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler {
    public static Collection<ItemInfo> getItemWithGroup(String s){
        Collection collection = Item.searchItems(s);
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for(Iterator iterator = collection.iterator(); iterator.hasNext();){
            Item item = (Item) iterator.next();
            items.add(new ItemInfo(item.getName(), item.getImagePath(), item.getPrice()));
        }
        return items;
    }
}
