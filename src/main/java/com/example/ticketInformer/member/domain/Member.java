package com.example.ticketInformer.member.domain;

import lombok.Getter;
//import com.example.ticketInformer.basket.domain.Basket;

import javax.persistence.*;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<Basket> basketList = new ArrayList<>();

}
