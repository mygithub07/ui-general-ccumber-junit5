
package com.test.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.inject.Inject;

import java.net.MalformedURLException;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import com.test.support.Global;
import com.test.support.BasePage;
import com.test.support.Helpers;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Initial integration test")
@Feature("Initial Integration test feature")
public class InitialIT extends BasePage {
//public class InitialIT  {
         private static final Logger logger = LoggerFactory.getLogger(InitialIT.class);
         String hubUrl = System.getProperty("hub.url");
         String sutUrl = System.getProperty("sut.url");
         List<WebElement> result;
         public static  ChromeDriver driver ;
         public static Helpers help;
         public static WebDriverWait wait;
         
     /*   
        @Inject
        Global global;
        */
       
        @Inject
        public InitialIT(Global global) {
         super(global);
        InitialIT.driver = (ChromeDriver) global.driver;
        InitialIT.wait = global.wait;
       // InitialIT.help = global.help;
    }  
    
   /* 
    public InitialIT() {
         
        InitialIT.driver = (ChromeDriver) global.driver;
        InitialIT.wait = global.wait;
       // InitialIT.help = global.help;
    }  
    
    */
    
     
    
     
    // @FindBy(css = "[placeholder=\"Search\"]")
    // public static WebElement search;
      
     @FindBy(xpath = "(//input[@placeholder='Search'])")
     public static WebElement search;
        
      @FindBy(xpath = "(//button[@class='btn btn-link pull-right'])")
      public static WebElement AddUser;
      
      @FindBy(xpath = "//input[@name='FirstName']")
      public static WebElement fName;
      
      @FindBy(xpath = "//input[@name='LastName']")
      public static WebElement lName;
      
      @FindBy(xpath = "//input[@name='UserName']")
      public static WebElement uName;
      
      @FindBy(xpath = "//input[@name='Password']")
      public static WebElement pWord;
      
      @FindBy(xpath = "//input[@name='optionsRadios']")
      public static List<WebElement> customer;
      
      @FindBy(xpath = "//select[@name='RoleId']")
      public static List<WebElement> role;
      
      @FindBy(xpath = "//option[text()='Sales Team']")
      public static WebElement sales;
      
      @FindBy(xpath = "//input[@name='Email']")
      public static WebElement email;
      
       @FindBy(xpath = "//input[@name='Mobilephone']")
      public static WebElement mphone;
       
       @FindBy(xpath = "//button[text()='Save']")
      public static WebElement save;
      
       
      //  @Given("^I open the site \"([^\"]*)\"$")
       @Test
       // @Story("enter new user story")
       // @Description("enter new user description")
        @Given("I open the site {string}")
        public void OpenSite(String site) throws MalformedURLException {
                // driver.get( "http://www.way2automation.com/angularjs-protractor/webtables/");
                driver.get(site);
                wait.until(ExpectedConditions.visibilityOf(search));
       }
       
       @Test
       @When("I add  user with the following information {string} {string} {string} {string} {string} {string}")
        public void AddUser(String fn,String ln,String uname,String pwd, String em, String cellphone) throws MalformedURLException, InterruptedException {
              
               AddUser.click();
                wait.until(ExpectedConditions.visibilityOf(fName));
                fName.sendKeys(fn);
                Thread.sleep(1000);
                lName.sendKeys(ln);
               Thread.sleep(1000);
                uName.sendKeys(uname);
               Thread.sleep(1000);
                pWord.sendKeys(pwd);
               Thread.sleep(1000);
                customer.get(0).click();
               Thread.sleep(1000);
                role.get(0).click();
                Thread.sleep(1000);
                sales.click();
               Thread.sleep(1000);
                email.sendKeys(em);
               Thread.sleep(1000);
                mphone.sendKeys(cellphone);
               Thread.sleep(1000);
                save.click();
               Thread.sleep(1000);

       }
         @After
        public void closeBrowser() {

             driver.quit();
      }

}
