package com.omen.www.listviewchat;

/**
 * Created by Administrator on 2016/7/24.
 */
public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String mContent;
    private int mType;

    public Msg(String Content, int type) {
        this.mContent = Content;
        this.mType = type;
    }

    public String getContent() {
        return mContent;
    }

    public int getType() {
        return mType;
    }
}
