package com.example.ticketInformer.crawling.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class TicketLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private int rank;
    public TicketLink(){}

    public TicketLink(String date,String name,int rank){
        this.name = name;
        this.date =date;
        this.rank = rank;


    }
}
