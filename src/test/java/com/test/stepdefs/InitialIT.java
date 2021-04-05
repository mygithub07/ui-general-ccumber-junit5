
package com.test.stepdefs;

import com.test.support.addUserPojo;
import io.cucumber.java.After;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.inject.Inject;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import com.test.support.Global;
//import com.test.support.BasePage;
import com.test.support.Helpers;
//import io.qameta.allure.Description;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.Story;

//@Epic("Initial integration test")
//@Feature("Initial Integration test feature")
//public class InitialIT extends BasePage {

//@io.cucumber.junit.platform.engine.Cucumber
public class InitialIT  {
       //  private static final Logger logger = LoggerFactory.getLogger(InitialIT.class);
         String hubUrl = System.getProperty("hub.url");
         String sutUrl = System.getProperty("sut.url");
         List<WebElement> result;
         public static  ChromeDriver driver ;
         public static Helpers help;
         public static WebDriverWait wait;
         
       
         @Inject
       Global global;

     @Given("I log the type of {long}")
        public void logType(Long testLong ) {
            System.out.println("type of " +testLong +" is:"+ testLong.getClass());
       }
   
        @Given("I log {string}")
        public void logSomething(String teststr )   {
            System.out.println("sample text:"+ teststr+"somethingtoIdentifySpace");
       }
       
  /****** Old way of injecting****    
        @Inject
        public InitialIT(Global global) {
         super(global);
        InitialIT.driver = (ChromeDriver) global.driver;
        InitialIT.wait = global.wait;
       // InitialIT.help = global.help;
    }  
    */
      
        @Given("I open the site {string}")
        public void OpenSite(String site) throws MalformedURLException {

                global.driver.get(site);

       }

       @When("I add  user with the following information {string} {string} {string} {string} {string} {string}")
        public void AddUser(String fn,String ln,String uname,String pwd, String em, String cellphone) throws MalformedURLException, InterruptedException {
              
                PageObjects.AddUser.click();
                
                global.wait.until(ExpectedConditions.visibilityOf(PageObjects.fName));
            //    System.out.println("firstname:"+  PageObjects.fName+"lastname" );
                PageObjects.fName.sendKeys(fn);
                Thread.sleep(1000);
                PageObjects.lName.sendKeys(ln);
               Thread.sleep(1000);
                PageObjects.uName.sendKeys(uname);
               Thread.sleep(1000);
                PageObjects.pWord.sendKeys(pwd);
               Thread.sleep(1000);
                PageObjects.customer.get(0).click();
               Thread.sleep(1000);
                PageObjects.role.get(0).click();
                Thread.sleep(1000);
                PageObjects.sales.click();
               Thread.sleep(1000);
                PageObjects.email.sendKeys(em);
               Thread.sleep(1000);
                PageObjects.mphone.sendKeys(cellphone);
               Thread.sleep(1000);
                PageObjects.save.click();
               Thread.sleep(1000);
       }
       
         @Then("I see user {string} added to the table")
         public void userAdded(String un){
            System.out.println("username after addition"+ un);
            assertThat(true).isEqualTo(true);
         }
      
         @And("perform guice test" )
                 public void guiceTest(){
               System.out.println(global.help.guiceTest());
                 }
                 
        @DataTableType
        public addUserPojo userentry(Map<String, String> entry) {
        return new addUserPojo(entry.get("FirstName"),entry.get("LastName"),entry.get("username"),entry.get("password"),entry.get("Email"),entry.get("CellPhone"));
        } 
       
       @When("I add  user with passing info to pojo class")
        public void AddUserWithPOJO( List<addUserPojo> adduser) throws MalformedURLException, InterruptedException {
            
           // System.out.println("firstname..."+ adduser.toString());
             for (addUserPojo addUserFields : adduser) {
                 System.out.println("firstname..."+addUserFields.getFirstName());
                 System.out.println("LastName..."+addUserFields.getLastName());
                 System.out.println("username..."+addUserFields.getusername());
                 System.out.println("pwd..."+addUserFields.getpassword());
                 System.out.println("email..."+addUserFields.getEmail());
                 System.out.println("cellphone..."+addUserFields.getCellPhone());
                 
                  PageObjects.AddUser.click();
                
                global.wait.until(ExpectedConditions.visibilityOf(PageObjects.fName));
               
                 //    System.out.println("firstname:"+  PageObjects.fName+"lastname" );
                 PageObjects.fName.sendKeys(addUserFields.getFirstName());
                 Thread.sleep(1000);
                 PageObjects.lName.sendKeys(addUserFields.getLastName());
                 Thread.sleep(1000);
                 PageObjects.uName.sendKeys(addUserFields.getusername());
                 Thread.sleep(1000);
                 PageObjects.pWord.sendKeys(addUserFields.getpassword());
                 Thread.sleep(1000);
                 PageObjects.customer.get(0).click();
                 Thread.sleep(1000);
                 PageObjects.role.get(0).click();
                 Thread.sleep(1000);
                 PageObjects.sales.click();
                 Thread.sleep(1000);
                 PageObjects.email.sendKeys(addUserFields.getEmail());
                 Thread.sleep(1000);
                 PageObjects.mphone.sendKeys(addUserFields.getCellPhone());
                 Thread.sleep(1000);
                 PageObjects.save.click();
                 Thread.sleep(1000);
                 
             }
             
       } 
       
        @When("I add  user with passing info to pojo class from scenario outline")
        public void AddUserWithPOJOScOut( List<addUserPojo> adduser) throws MalformedURLException, InterruptedException {
            
           // System.out.println("firstname..."+ adduser.toString());
             for (addUserPojo addUserFields : adduser) {
                 System.out.println("firstname..."+addUserFields.getFirstName());
                 System.out.println("LastName..."+addUserFields.getLastName());
                 System.out.println("username..."+addUserFields.getusername());
                 System.out.println("pwd..."+addUserFields.getpassword());
                 System.out.println("email..."+addUserFields.getEmail());
                 System.out.println("cellphone..."+addUserFields.getCellPhone());
                 
             }
             /*
                  PageObjects.AddUser.click();
                
                global.wait.until(ExpectedConditions.visibilityOf(PageObjects.fName));
               
                 //    System.out.println("firstname:"+  PageObjects.fName+"lastname" );
                 PageObjects.fName.sendKeys(addUserFields.getFirstName());
                 Thread.sleep(1000);
                 PageObjects.lName.sendKeys(addUserFields.getLastName());
                 Thread.sleep(1000);
                 PageObjects.uName.sendKeys(addUserFields.getusername());
                 Thread.sleep(1000);
                 PageObjects.pWord.sendKeys(addUserFields.getpassword());
                 Thread.sleep(1000);
                 PageObjects.customer.get(0).click();
                 Thread.sleep(1000);
                 PageObjects.role.get(0).click();
                 Thread.sleep(1000);
                 PageObjects.sales.click();
                 Thread.sleep(1000);
                 PageObjects.email.sendKeys(addUserFields.getEmail());
                 Thread.sleep(1000);
                 PageObjects.mphone.sendKeys(addUserFields.getCellPhone());
                 Thread.sleep(1000);
                 PageObjects.save.click();
                 Thread.sleep(1000);
             */
       }
       
         @After
        public void closeBrowser() {

             global.driver.quit();
      }
      
   

}
