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

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveTicketLinkItem(TicketLink ticketLink,ItemGenre itemGenre){
        Item item = new Item(ticketLink.getName(), ticketLink.getDate(),ticketLink.getRank(), ItemSource.TICKETLINK,itemGenre);
        itemRepository.save(item);
    }
    public void saveInterParkItem(InterPark interPark, ItemGenre itemGenre){
        Item item = new Item(interPark.getName(), interPark.getDate(),interPark.getRank(), ItemSource.INTERPARK,itemGenre);
        itemRepository.save(item);
    }
    public void savePlayKfaItem(PlayKfa playKfa, ItemGenre itemGenre){
        Item item = new Item(playKfa.getName(), playKfa.getDate(),playKfa.getRank(), ItemSource.PLAYKFA,itemGenre);
        itemRepository.save(item);
    }
}
