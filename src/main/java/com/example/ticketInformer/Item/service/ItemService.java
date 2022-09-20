package com.example.ticketInformer.Item.service;


import com.example.ticketInformer.Item.domain.Item;
import com.example.ticketInformer.Item.domain.ItemGenre;
import com.example.ticketInformer.Item.domain.ItemSource;
import com.example.ticketInformer.Item.repository.ItemRepository;
import com.example.ticketInformer.crawling.domain.InterPark;
import com.example.ticketInformer.crawling.domain.PlayKfa;
import com.example.ticketInformer.crawling.domain.TicketLink;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveTicketLinkItem(TicketLink ticketLink,ItemGenre itemGenre,String imageUrl){
        Item item = new Item(ticketLink.getName(), ticketLink.getDate(),ticketLink.getRank(), ItemSource.TICKETLINK,itemGenre,imageUrl);
        itemRepository.save(item);
    }
    public void saveInterParkItem(InterPark interPark, ItemGenre itemGenre,String imageUrl){
        Item item = new Item(interPark.getName(), interPark.getDate(),interPark.getRank(), ItemSource.INTERPARK,itemGenre,imageUrl);
        itemRepository.save(item);
    }
    public void savePlayKfaItem(PlayKfa playKfa, ItemGenre itemGenre,String imageUrl){
        Item item = new Item(playKfa.getName(), playKfa.getDate(),playKfa.getRank(), ItemSource.PLAYKFA,itemGenre,imageUrl);
        itemRepository.save(item);
    }
    public List<Item> getAllItems(){
        List<Item> items = itemRepository.findAll();
        return items;
    }
}
