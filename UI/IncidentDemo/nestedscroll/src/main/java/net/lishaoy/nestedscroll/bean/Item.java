package net.lishaoy.nestedscroll.bean;

public class Item {
    private int icon;
    private String text;
    private Class activity;

    public Class getActivity() {
        return activity;
    }

    public void setActivity(Class activity) {
        this.activity = activity;
    }

    public Item(int icon, String text, Class activity) {
        this.icon = icon;
        this.text = text;
        this.activity = activity;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }

    public Item(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }
}
