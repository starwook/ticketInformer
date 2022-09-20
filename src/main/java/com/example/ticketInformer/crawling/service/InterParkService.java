package com.example.ticketInformer.crawling.service;


import com.example.ticketInformer.Item.domain.ItemGenre;
import com.example.ticketInformer.Item.domain.ItemSource;
import com.example.ticketInformer.Item.service.ItemService;
import com.example.ticketInformer.crawling.Selenium;
import com.example.ticketInformer.crawling.domain.InterPark;
import com.example.ticketInformer.crawling.repository.InterParkRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterParkService {

    private static final String urlInterPark = "http://ticket.interpark.com/Contents/Ranking";
    private final InterParkRepository interParkRepository;
    private final ItemService itemService;

    public void getInterParkRanking(){
        Selenium sel = new Selenium();
        WebDriver driver = sel.getDriver();
        driver.get(urlInterPark);
        try{

            String html = driver.getPageSource();
            Document doc = Jsoup.parse(html);
            Elements elements =doc.select("body > div.wrap > div.rankingMain");
            for(int i=1;i<=8;i++){
                ItemGenre itemGenre = reItemGenre(i);
                Elements eachGenre = elements.select("div[class=rankingGenre genre"+i+"]");
                Elements eachItemList = eachGenre.select("div[class= items]:nth-child(2)");
                for(int j=1;j<=3;j++){
                    Elements eachItem = eachItemList.select("li:nth-child("+j+")");
                    //img Crawl
                    Elements imageElements = eachItem.select("a[class=prdImg]");
                    String imageUrl = imageElements.select("img").attr("src");
                    // name,period Crawl
                    String name = eachItem.select("a[class=prdName]").text();
                    String time = eachItem.select("a[class=prdDuration]").text();
                    InterPark interPark = new InterPark(name,time,j);
                    interParkRepository.save(interPark);
                    itemService.saveInterParkItem(interPark, itemGenre,imageUrl);
                }

            }

        }
        catch(Exception e){
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
            return ItemGenre.CONCERT;
        }
        else if(i==3){
            return ItemGenre.THEATER;
        }
        else if(i==4){
            return ItemGenre.CLASSIC;
        }
        else if(i==5){
            return ItemGenre.SPORTS;
        }
        else if(i==6){
            return ItemGenre.LEISURE;
        }
        else if(i==7){
            return ItemGenre.FESTIVAL;
        }
        else {
            return ItemGenre.FAMILY;
        }
    }
}
