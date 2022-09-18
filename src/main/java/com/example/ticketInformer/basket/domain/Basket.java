//package com.example.ticketInformer.basket.domain;
//
//import com.example.ticketInformer.Item.domain.Item;
//import com.example.ticketInformer.user.domain.Member;
//import lombok.Getter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//public class Basket {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "basket_id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name ="member_id")
//    private Member member;
//
//    @ManyToOne
//    @JoinColumn(name ="item_id")
//    private Item item;
//
//
//}
