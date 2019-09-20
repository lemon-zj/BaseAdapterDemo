package com.huaqin.lxbaseadapter;

import android.widget.ImageView;

public class ItemBean {
    private int ImageResId;
    private String title;
    private String neirong;

    public ItemBean(int imageResId, String title, String neirong) {
        ImageResId = imageResId;
        this.title = title;
        this.neirong = neirong;
    }

    public int getImageResId() {
        return ImageResId;
    }

    public void setImageResId(int imageResId) {
        ImageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
}
