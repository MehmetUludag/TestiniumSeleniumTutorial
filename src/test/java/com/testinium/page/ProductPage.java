package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
public class ProductPage {
    Methods methods ;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage(){
        methods = new Methods();
    }

    public void scrollAndSelect(){
        methods.sendKeys(By.id("search-input"),"edebiyat");
        methods.waitBySeconds(5);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(5);
        methods.click(By.cssSelector(".pr-img-link"));
        methods.waitBySeconds(5);
        methods.scrollWithAction(By.cssSelector("#review-reply-button"));
        methods.waitBySeconds(5);
        methods.selectByText(By.cssSelector("select#review-sort-selection"),
                "Oylama (Düşük > Yüksek)");
        methods.waitBySeconds(5);
    }

    public void attributeTest(){
        String attribute = methods.getAttribute(By.cssSelector(".logo-text>a>img"),"title");
        System.out.println("Alınan text: " + attribute);
        logger.info("Alınan text: " + attribute);
        methods.waitBySeconds(5);
    }

    public void textControlTest(){
        String text = methods.getText(By.cssSelector(".common-sprite"));
        System.out.println("Alınan text: " +text);
        logger.info("Alınan text: " +text);
        methods.waitBySeconds(5);
    }

    public void valueControlTest(){
        methods.sendKeys(By.id("search-input"),"testinium");
        String value = methods.getValue(By.id("search-input"));
        System.out.println("Alınan text: " + value);
        logger.info("Alınan text: " + value);
        Assert.assertEquals("testinium",value);
        methods.waitBySeconds(5);
    }

}