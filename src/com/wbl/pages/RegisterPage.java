package com.wbl.pages;

import com.wbl.utils.web.PageDriver;

/**
 * Created by bindunani on 10/5/15.
 */
public class RegisterPage extends PortalPage  {

    private final static String REGISTER_SUCCESS_MESSAGE = "You are registered";

    private String fullNameField = "name=fullname";
    private String phoneField = "name=phone";
    private String addressField = "name=address";
    private String cityField = "name=city";
    private String zipField = "name=zip";
    private String countryField = "name=country";
    private String registerButton = "id=register";

    public RegisterPage(PageDriver driver) {
        super(driver);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public void fillRegistrationForm(String fullname,String phone,String address,
                                     String city,String zip,String country){
        driver.findElement(fullNameField).sendKeys(fullname);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(countryField).sendKeys(country);

    }

    public void clickRegistrationButton(){
        driver.findElement(registerButton).click();
        driver.waitForLoad();
    }

    public boolean isRegistrationCompleted(){
        return driver.findElement(".contact-form h4").getText().contains(REGISTER_SUCCESS_MESSAGE);
    }

}
