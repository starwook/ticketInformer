package com.example.ticketInformer.Item.repository;

import com.example.ticketInformer.Item.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void showDate(){
        List<Item> items =itemRepository.findAll();
        for(int i=0;i<items.size();i++){
            System.out.println(items.get(i).getCreatedDate()+":createdDate,"+items.get(i).getModifiedDate() +":modifiedDate");
        }
    }


}