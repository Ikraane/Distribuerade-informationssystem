package bo;

import ui.UserInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UserHandler {
    public static Collection<UserInfo> getUser(String s){
        Collection collection = User.searchUser(s);
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        for(Iterator iterator = collection.iterator(); iterator.hasNext();){
            User user = (User) iterator.next();
            users.add(new UserInfo(user.getUsername(), user.getPassword()));
        }
        return users;
    }
}
