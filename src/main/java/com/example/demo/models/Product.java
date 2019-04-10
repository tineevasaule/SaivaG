package com.example.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public String name;
    private int kolichestvo;

    private String imageUrl;
//    @OneToOne
////    private  Orders orders;
//
//
//
//
//    public Product() {
//    }




//    public void setOrders(Orders orders) {
//        this.orders = orders;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getProfessii() {
//        return professii;
//    }
//
//    public void setProfessii(String professii) {
//        this.professii = professii;
//    }
//    public  String getName()
//    {
//        return Name;
//    }



    public int getKolichestvo() {
        return kolichestvo;
    }

    public void setKolichestvo(int kolichestvo) {
        this.kolichestvo = kolichestvo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}