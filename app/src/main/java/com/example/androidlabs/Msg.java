package com.example.androidlabs;

public class Msg {
    public static final int TYPE_RECE = 0;
    public static final int TYPE_SEND = 1;

    private String content;
    private  long id;
    boolean isSend;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
        //if(type==TYPE_RECE) isSend=false;
        //else  isSend=true;

    }
    public Msg(String content, int type, long id) {

        this.id=id;
        this.content = content;
        this.type = type;
        if(type==TYPE_RECE) isSend=false;
        else  isSend=true;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
    public long getId(){return  id;}
    public boolean isSend(){return  isSend;}
}