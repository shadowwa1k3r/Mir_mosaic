package com.odinson.loki.mir_mosaic;

/**
 * Created by ergas on 10/30/2017.
 */

public class itemtype {
    private String name;
    private int thumbnail;

    public itemtype(String name,int thumbnail){
        this.name=name;
        this.thumbnail=thumbnail;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getThumbnail() {

        return thumbnail;
    }
}
