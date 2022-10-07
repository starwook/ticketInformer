package com.example.ticketInformer.crawling.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class InterPark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String date;
    private int interParkRank;
    public InterPark(){

    }

    public InterPark(String name, String date, int interParkRank) {
        this.name = name;
        this.date = date;
        this.interParkRank = interParkRank;
    }
}
