package com.example.mealrater;

public class MealRaterDataSource {
    public MealRaterDataSource(String rname, String dname, String rating) {
        this.rname = rname;
        this.dname = dname;
        this.rating = rating;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    String rname, dname, rating;

}
