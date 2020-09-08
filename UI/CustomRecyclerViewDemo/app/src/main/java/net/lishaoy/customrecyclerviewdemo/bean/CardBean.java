package net.lishaoy.customrecyclerviewdemo.bean;

import android.content.res.Resources;

import net.lishaoy.customrecyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class CardBean {

    private int position;
    private int resource;
    private String name;

    public CardBean(int position, int resource, String name) {
        this.position = position;
        this.resource = resource;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<CardBean> getCardData() {
        List<CardBean> cardBeans = new ArrayList<>();
        int[] resources = new int[]{
                R.mipmap.bg1,
                R.mipmap.bg2,
                R.mipmap.bg3,
                R.mipmap.bg4,
                R.mipmap.bg5,
                R.mipmap.bg6,
                R.mipmap.bg7,
                R.mipmap.bg8
        };
        for (int i = 0; i < resources.length; i++) {
            cardBeans.add(new CardBean(i + 1, resources[i], "card" + (i + 1)));
        }

        return cardBeans;
    }
}
