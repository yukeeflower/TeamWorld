package com.example.piaoxuehua.teamworldapplication;

/**
 * Created by piaoxuehua on 2017/5/17.
 */

public class Model {
    private String name;
    private String school;
    private String jianjie;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getSeximage() {
        return seximage;
    }

    public void setSeximage(int seximage) {
        this.seximage = seximage;
    }

    private int seximage;

    public Model() {
    }
}
