package com.example.ticketInformer.crawling.domain;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class InterPark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String date;
    private int rank;
    public InterPark(){

    }

    public InterPark(String name, String date, int rank) {
        this.name = name;
        this.date = date;
        this.rank = rank;
    }
}
