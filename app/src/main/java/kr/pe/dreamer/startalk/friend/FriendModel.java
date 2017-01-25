package kr.pe.dreamer.startalk.friend;

import java.util.ArrayList;

/**
 * Created by rhdlr on 2017-01-25.
 */

public class FriendModel {
    private ArrayList<FriendModel.Item> items;

    public FriendModel(){
        createFriendList();
    }

    public void createFriendList() {
        ArrayList<FriendModel.Item> items = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            FriendModel.Item item = new FriendModel.Item();
            item.setImage("Friend Image : " + i);
            item.setName("Friend Name : " + i);
            item.setMessage("Friend Message : " + i);

            items.add(item);
        }

        this.items = items;
    }

    public FriendModel.Item getItem(int position) {
        return items.get(position);
    }

    public int getCount(){
        return items.size();
    }

    public ArrayList getFriendList() {
        return items;
    }

    public class Item {
        private String image;
        private String name;
        private String message;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}


