package net.lishaoy.materialdesigndemo.bean;

public class NavListItem {
    private int icon;
    private String text;
    private Class activity;

    public NavListItem(int icon, String text, Class activity) {
        this.icon = icon;
        this.text = text;
        this.activity = activity;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Class getActivity() {
        return activity;
    }

    public void setActivity(Class activity) {
        this.activity = activity;
    }
}
