package com.example.ticketInformer.config;

import com.example.ticketInformer.crawling.domain.PlayKfa;
import com.example.ticketInformer.crawling.service.InterParkService;
import com.example.ticketInformer.crawling.service.PlayKfaService;

import com.example.ticketInformer.crawling.service.TicketLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartConfig implements ApplicationRunner {


    private final InterParkService interParkService;
    private final PlayKfaService playKfaService;
    private final TicketLinkService ticketLinkService;
    @Override
    public void run(ApplicationArguments args) throws Exception{
//        interParkService.getInterParkRanking();
//        playKfaService.getPlayKfa();
        ticketLinkService.getTicketLinkRanking();
    }
}
