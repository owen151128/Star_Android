package kr.pe.dreamer.startalk.chattiong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import kr.pe.dreamer.startalk.friend.FriendModel;

/**
 * Created by rhdlr on 2017-01-25.
 */

public class ChattingModel {
    private ArrayList<ChattingModel.Item> items;

    public ChattingModel() {
        createFriendList();
    }

    public void createFriendList() {
        ArrayList<ChattingModel.Item> items = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ChattingModel.Item item = new ChattingModel.Item();
            item.setImage("Friend Image : " + i);
            item.setName("Friend Name : " + i);
            item.setMessage("Friend Message : " + i);
            item.setPersonnel(i);
            item.setTime(getCurrentTime());
            item.setMessageCount(i);

            items.add(item);
        }

        this.items = items;
    }

    public int getCount() {
        return items.size();
    }

    public ChattingModel.Item getItem(int position) {
        return items.get(position);
    }

    private String getCurrentTime() {
        long currentTime = System.currentTimeMillis();
        Date date = new Date(currentTime);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        return sdf.format(date);
    }

    public class Item {
        private String image;
        private String name;
        private String message;
        private String time;
        private int personnel;
        private int messageCount;

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

        public int getPersonnel() {
            return personnel;
        }

        public void setPersonnel(int personnel) {
            this.personnel = personnel;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getMessageCount() {
            return messageCount;
        }

        public void setMessageCount(int messageCount) {
            this.messageCount = messageCount;
        }
    }
}
