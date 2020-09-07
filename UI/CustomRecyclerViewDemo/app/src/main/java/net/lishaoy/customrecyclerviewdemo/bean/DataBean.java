package net.lishaoy.customrecyclerviewdemo.bean;

public class DataBean {

    private String text;
    private String groupText;

    public DataBean(String text, String groupText) {
        this.text = text;
        this.groupText = groupText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getGroupText() {
        return groupText;
    }

    public void setGroupText(String groupText) {
        this.groupText = groupText;
    }
}
