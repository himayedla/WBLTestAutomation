package com.wbl.pages;

import com.wbl.utils.web.HtmlElement;
import com.wbl.utils.web.PageDriver;
import org.apache.commons.exec.util.StringUtils;
import org.apache.poi.util.StringUtil;

import java.util.Collection;
import java.util.List;
/**
 * Created by svelupula on 8/14/2015.
 */
public class HomePage extends PortalPage {

    public HomePage(PageDriver driver) {
        super(driver);
        _logger.debug("Open Home Page");
        driver.findElement("header.home").click();
    }

    public int getSliderItemsCount() {
        return driver.findElements("home.slider.items").size();
    }

    public boolean isLatestNewsSectionPresent(){
        return driver.findElement(".new").isDisplayed();
    }

    public boolean isPromoSectionPresent(){
        return driver.findElement(".promo").isDisplayed();
    }

    public boolean isRecentClassesSectionsPresent(){
        return driver.findElement(".events").isDisplayed();
    }

    public int getRecentClassesEntries(){
        return driver.findElements(".events .event-item").size();
    }

    public boolean isVideoSectionPresent(){
        return driver.findElement("#videos-carousel").isDisplayed();
    }

    public boolean isTestimonialsSectionPresent(){
        return driver.findElement(".testimonials").isDisplayed();
    }

    public boolean isFooterPresent(){
        return driver.findElement(".footer").isDisplayed();
    }

    public boolean isContactInfoPresentInFooter(){
        return (driver.findElements(".contact p a").size() ==2 &&
                driver.findElements(".adr-group").size() ==2);
    }

    public LoginPage clickLogin(){
        driver.findElement("#loginButton").click();
        driver.waitForLoad();
        return new LoginPage(driver);
    }

}
