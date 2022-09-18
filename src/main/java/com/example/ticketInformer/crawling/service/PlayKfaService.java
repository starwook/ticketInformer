package com.example.ticketInformer.crawling.service;


import com.example.ticketInformer.Item.domain.ItemGenre;
import com.example.ticketInformer.Item.service.ItemService;
import com.example.ticketInformer.crawling.Selenium;
import com.example.ticketInformer.crawling.domain.PlayKfa;
import com.example.ticketInformer.crawling.repository.PlayKfaRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayKfaService {
    private static final String urlPlayKfa = "https://shop.playkfa.com/login";
    private final PlayKfaRepository playKfaRepository;

    private static final String id = "kawaiibbit";
    private static final String password ="cjswo78!";
    private final ItemService itemService;
    public void getPlayKfa(){
        Selenium sel = new Selenium();
        WebDriver driver = sel.getDriver();
        driver.get(urlPlayKfa);
        try{

            driver.findElement(By.cssSelector("#loginID")).sendKeys(id);
            driver.findElement(By.cssSelector("#loginPW")).sendKeys(password);
            driver.findElement(By.cssSelector("#form_login > button")).click();
            Thread.sleep(300);
            byWhatTeam(driver,"https://shop.playkfa.com/ticket/mennationalteam","  (남자국가대표)");
            byWhatTeam(driver,"https://shop.playkfa.com/ticket/menolympic", "  (남자올림픽대표)");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
        }
    }
    public void byWhatTeam(WebDriver driver,String url,String whatTeam){
        driver.navigate().to(url); //국대
        String html = driver.getPageSource();
        Document doc = Jsoup.parse(html);
//            Elements adultItems = doc.select("body > div > div.content.sub.ticket > div.content-section > div.ticket-content > div.tabs > div.tab-content.on");
//            System.out.println(adultItems);
        Elements eachItem = doc.select("li[class=ticket]");
        for(Element e :eachItem){
            Elements date = e.select("dl[class=date] >dd>strong");
            Elements time = e.select("dl[class=time] >dd>strong");
            String when = date.text()+" "+time.text();
            Elements homeTeam = e.select("dt[class=team home]");
            Elements awayTeam = e.select("dt[class=team away]");
            String name = homeTeam.text()+" VS "+awayTeam.text()+whatTeam;
            PlayKfa playKfa = new PlayKfa(name,when,0);
            playKfaRepository.save(playKfa);
            ItemGenre itemGenre = ItemGenre.SPORTS;
            itemService.savePlayKfaItem(playKfa,itemGenre);
        }

    }
}
