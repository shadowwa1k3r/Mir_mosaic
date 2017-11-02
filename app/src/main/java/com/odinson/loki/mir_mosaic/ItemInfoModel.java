package com.odinson.loki.mir_mosaic;

/**
 * Created by ergas on 11/2/2017.
 */

public class ItemInfoModel {
    private String name;
    private String code;
    private String cost;
    private String material;
    private int img;
    private String soldBy;
    private String  sheetSize;
    private String packing;
    private String sqFtBox;
    private String weight;

    public ItemInfoModel(String name,String code,String cost,String material,String soldBy,String sheetSize,String packing,String sqFtBox,String weight,int img){
        this.code=code;this.name=name;this.cost=cost;this.material=material;this.img=img;this.soldBy=soldBy;this.sheetSize=sheetSize;this.packing=packing;
        this.sqFtBox=sqFtBox;this.weight=weight;
    }

    public int getImg() {
        return img;
    }

    public void setWeight(String weight) {

        this.weight = weight;
    }

    public String getWeight() {

        return weight;
    }

    public void setSqFtBox(String sqFtBox) {

        this.sqFtBox = sqFtBox;
    }

    public String getSqFtBox() {

        return sqFtBox;
    }

    public void setPacking(String packing) {

        this.packing = packing;
    }

    public String getPacking() {

        return packing;
    }

    public void setSheetSize(String sheetSize) {

        this.sheetSize = sheetSize;
    }

    public String getSheetSize() {

        return sheetSize;
    }

    public void setSoldBy(String soldBy) {

        this.soldBy = soldBy;
    }

    public String getSoldBy() {

        return soldBy;
    }

    public void setMaterial(String material) {

        this.material = material;
    }

    public String getMaterial() {

        return material;
    }

    public void setCost(String cost) {

        this.cost = cost;
    }

    public String getCost() {

        return cost;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getCode() {

        return code;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
