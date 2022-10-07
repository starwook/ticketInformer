package com.example.ticketInformer.crawling.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PlayKfa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;

    private int playKfaRank;

    public  PlayKfa(){

    }
    public PlayKfa(String name, String date, int rank) {
        this.name = name;
        this.date = date;
        this.playKfaRank = rank;
    }
}
