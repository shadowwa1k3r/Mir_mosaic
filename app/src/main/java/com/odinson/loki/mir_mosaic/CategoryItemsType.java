package com.odinson.loki.mir_mosaic;

/**
 * Created by ergas on 11/1/2017.
 */

public class CategoryItemsType {
    private String name;
    private String code;
    private String material;
    private String cost;
    private int img;

    public CategoryItemsType(String name,String code,String cost,String material,int img){
        this.name=name;
        this.cost = cost;
        this.code=code;
        this.material=material;
        this.img=img;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCost() {

        return cost;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {

        return material;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {

        return code;
    }
}
