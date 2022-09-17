package com.example.ticketInformer.Item.domain;

import lombok.Getter;
import com.example.ticketInformer.basket.domain.Basket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String date;
    private String name;
    private int rank;

    @Enumerated(EnumType.STRING)
    private ItemSource itemSource;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Basket> basketList = new ArrayList<>();
    public Item(){

    }
    public Item( String name,String date, int rank, ItemSource itemSource) {
        this.name = name;
        this.date = date;
        this.rank = rank;
        this.itemSource = itemSource;
    }
}
