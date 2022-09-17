package com.example.ticketInformer.Item.service;


import com.example.ticketInformer.Item.domain.Item;
import com.example.ticketInformer.Item.domain.ItemSource;
import com.example.ticketInformer.Item.repository.ItemRepository;
import com.example.ticketInformer.crawling.domain.TicketLink;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveTicketLinkItem(TicketLink ticketLink){
        Item item = new Item(ticketLink.getName(), ticketLink.getDate(),ticketLink.getRank(), ItemSource.TICKETLINK);
        itemRepository.save(item);
    }
}
