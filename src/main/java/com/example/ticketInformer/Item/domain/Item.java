package com.example.ticketInformer.Item.domain;

import com.example.ticketInformer.entity.BaseTimeEntity;
import lombok.Getter;
//import com.example.ticketInformer.basket.domain.Basket;

import javax.persistence.*;

@Entity
@Getter
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String itemDate;
    private String itemName;
    private int itemRank;
    private String imgUrl;
    private String url;



    @Enumerated(EnumType.STRING)
    private ItemSource itemSource;
    @Enumerated(EnumType.STRING)
    private ItemGenre itemGenre;

    public Item(String itemName, String itemDate, int itemRank, ItemSource itemSource, ItemGenre itemGenre, String imgUrl, String url) {
        this.itemDate = itemDate;
        this.itemName = itemName;
        this.itemRank = itemRank;
        this.imgUrl = imgUrl;
        this.itemSource = itemSource;
        this.itemGenre = itemGenre;
        this.url = url;
    }
    public Item(String itemName, String itemDate, int itemRank, ItemSource itemSource, ItemGenre itemGenre, String imgUrl) {
        this.itemDate = itemDate;
        this.itemName = itemName;
        this.itemRank = itemRank;
        this.imgUrl = imgUrl;
        this.itemSource = itemSource;
        this.itemGenre = itemGenre;
    }


    //    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//    private List<Basket> basketList = new ArrayList<>();
    public Item(){

    }
    public Item(String itemName, String itemDate, int itemRank, ItemSource itemSource, ItemGenre itemGenre) {
        this.itemName = itemName;
        this.itemDate = itemDate;
        this.itemRank = itemRank;
        this.itemSource = itemSource;
        this.itemGenre =itemGenre;
    }
    public Item(String itemName, String itemDate, int itemRank, ItemSource itemSource) {
        this.itemName = itemName;
        this.itemDate = itemDate;
        this.itemRank = itemRank;
        this.itemSource = itemSource;
    }
}
