package com.example.ticketInformer.crawling.service;


import com.example.ticketInformer.Item.domain.Item;
import com.example.ticketInformer.Item.service.ItemService;
import com.example.ticketInformer.crawling.Selenium;
import com.example.ticketInformer.crawling.domain.TicketLink;
import com.example.ticketInformer.crawling.repository.TicketLinkRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;




@Slf4j
@RequiredArgsConstructor
@Service
public class TicketLinkService {
    private static final String urlTicketLink ="http://www.ticketlink.co.kr/ranking";
    private final TicketLinkRepository ticketLinkRepository;
    private final ItemService itemService;
    @PostConstruct
    public void getTicketLinkRanking() {
        Selenium sel = new Selenium();
        System.out.println("ohYeah");
        WebDriver driver = sel.getDriver();
        driver.get(urlTicketLink);
        try{
            String html = driver.getPageSource();
            Document doc = Jsoup.parse(html);
            Elements elements = doc.select("#content > section.common_section.section_ranking_weekly > div.common_inner > div.product_grid > ul");
            for(int i=1;i<=5;i++){
                Elements eachItem = elements.select("li:nth-child("+i+")");
                Elements eachItemInfo = eachItem.select("div>a>div:nth-child(2)");
                Elements name = eachItemInfo.select("span[class = product_title]");
                Elements time = eachItemInfo.select("div>div>span");
                System.out.println(name);

                TicketLink ticketLink = new TicketLink(time.text(),name.text(),i);

                ticketLinkRepository.save(ticketLink);
                itemService.saveTicketLinkItem(ticketLink);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
        }
    }

}
