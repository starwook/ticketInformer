package com.example.ticketInformer.crawling.service;


import com.example.ticketInformer.Item.domain.Item;
import com.example.ticketInformer.Item.domain.ItemGenre;
import com.example.ticketInformer.Item.service.ItemService;
import com.example.ticketInformer.crawling.Selenium;
import com.example.ticketInformer.crawling.domain.TicketLink;
import com.example.ticketInformer.crawling.repository.TicketLinkRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;


@Slf4j
@RequiredArgsConstructor
@Service
public class TicketLinkService {
    private static final String urlTicketLink ="http://www.ticketlink.co.kr/ranking";
    private final TicketLinkRepository ticketLinkRepository;
    private final ItemService itemService;

    public void getTicketLinkRanking() {
        Selenium sel = new Selenium();
        WebDriver driver = sel.getDriver();
        driver.get(urlTicketLink);
        try{
            WebElement ele = driver.findElement(By.cssSelector("#content > section.common_section.section_ranking_detail > div.common_tab.type_capsule > div > ul"));
            for(int i=1;i<=7;i++){
                WebElement eachGenre = ele.findElement(By.cssSelector("li:nth-child("+i+") "));
                WebElement eachButton = eachGenre.findElement(By.cssSelector("button"));
                System.out.println(eachButton.getText());
                eachButton.click();
                Thread.sleep(300);

                String html = driver.getPageSource();
                Document doc = Jsoup.parse(html);
                Elements elements = doc.select("#content > section.common_section.section_ranking_detail > div.ranking_product > table > tbody");
                for(int j=1;j<=3;j++){
                    Elements eachItem = elements.select("tr:nth-child("+j+")");
                    String name = eachItem.select("span[class=ranking_product_title]").text();
                    String time = eachItem.select("span[class=ranking_product_period]").text();
                    if(!name.isEmpty()){
                        TicketLink ticketLink = new TicketLink(time,name,j);
                        ticketLinkRepository.save(ticketLink);
                        ItemGenre itemGenre =reItemGenre(i);
                        itemService.saveTicketLinkItem(ticketLink,itemGenre);
                    }
                }
            }

//탑 5만 뽑기기
//            String html = driver.getPageSource();
//            Document doc = Jsoup.parse(html);
//            Elements elements = doc.select("#content > section.common_section.section_ranking_weekly > div.common_inner > div.product_grid > ul");
//            for(int i=1;i<=5;i++){
//                Elements eachItem = elements.select("li:nth-child("+i+")");
//                Elements eachItemInfo = eachItem.select("div>a>div:nth-child(2)");
//                Elements name = eachItemInfo.select("span[class = product_title]");
//                Elements time = eachItemInfo.select("div>div>span");
//                System.out.println(name);
//
//                TicketLink ticketLink = new TicketLink(time.text(),name.text(),i);
//
//                ticketLinkRepository.save(ticketLink);
//                itemService.saveTicketLinkItem(ticketLink);
//            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
        }
    }
    public ItemGenre reItemGenre(int i){
        if(i==1){
            return ItemGenre.MUSICAL;
        }
        else if(i==2){
            return ItemGenre.THEATER;
        }
        else if(i==3){
            return ItemGenre.CONCERT;
        }
        else if(i==4){
            return ItemGenre.CLASSIC;
        }
        else if(i==5){
            return ItemGenre.FAMILY;
        }
        else if(i==6){
            return ItemGenre.FESTIVAL;
        }
        else {
            return ItemGenre.LEISURE;
        }

    }

}
