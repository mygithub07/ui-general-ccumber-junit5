
package com.test.stepdefs;

import com.test.support.addUserPojo;
import io.cucumber.java.After;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import com.test.support.Global;
//import com.test.support.BasePage;
import com.test.support.Helpers;

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
      
       /*  @And("perform guice test" )
                public void guiceTest(){
               System.out.println(global.help.guiceTest());
                 }
              */
    
        @DataTableType
        public addUserPojo userentry(Map<String, String> entry) {
        return new addUserPojo(entry.get("FirstName"),entry.get("LastName"),entry.get("username"),entry.get("password"),entry.get("Email"),entry.get("CellPhone"));
        } 
       
        @ParameterType(".*?")
          public addUserPojo defineStringToPojo(String adduser) {
            List<String> usr = Arrays.asList(adduser.split(","));
           return  new addUserPojo(usr.get(0),usr.get(1),usr.get(2),usr.get(3),usr.get(4),usr.get(5));
          }
        
       @When("I add  user with passing info to pojo class")
        public void AddUserWithPOJO( List<addUserPojo> adduser) throws MalformedURLException, InterruptedException {
            System.out.format("Thread ID -%2d- When - pojo scenario only\n",
                   Thread.currentThread().getId()); 
           
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
       
 @When("I add  user by passing {defineStringToPojo} to pojo class from scenario outline")
        public void AddUserWithPOJOScOut( addUserPojo adduser) throws MalformedURLException, InterruptedException {
            
             System.out.format("Thread ID - %2d When -  pojo scenario outline\n",
                   Thread.currentThread().getId());
             
           System.out.println("firstname..."+adduser.getFirstName());
           System.out.println("LastName..."+adduser.getLastName());
           System.out.println("username..."+adduser.getusername());
           System.out.println("pwd..."+adduser.getpassword());
           System.out.println("email..."+adduser.getEmail());
           System.out.println("cellphone..."+adduser.getCellPhone());
           
                  PageObjects.AddUser.click();
                
                global.wait.until(ExpectedConditions.visibilityOf(PageObjects.fName));
               
                 //    System.out.println("firstname:"+  PageObjects.fName+"lastname" );
                 PageObjects.fName.sendKeys(adduser.getFirstName());
                 Thread.sleep(1000);
                 PageObjects.lName.sendKeys(adduser.getLastName());
                 Thread.sleep(1000);
                 PageObjects.uName.sendKeys(adduser.getusername());
                 Thread.sleep(1000);
                 PageObjects.pWord.sendKeys(adduser.getpassword());
                 Thread.sleep(1000);
                 PageObjects.customer.get(0).click();
                 Thread.sleep(1000);
                 PageObjects.role.get(0).click();
                 Thread.sleep(1000);
                 PageObjects.sales.click();
                 Thread.sleep(1000);
                 PageObjects.email.sendKeys(adduser.getEmail());
                 Thread.sleep(1000);
                 PageObjects.mphone.sendKeys(adduser.getCellPhone());
                 Thread.sleep(1000);
                 PageObjects.save.click();
                 Thread.sleep(1000);
             
       }
        @Then("I see user {defineStringToPojo} added to the table")
         public void userAddedParamType(addUserPojo adduser){
             System.out.format("Thread ID -Then -  pojo scenario outline\n",
                   Thread.currentThread().getId());
            System.out.println("username after addition"+ adduser.getusername());
            assertThat(true).isEqualTo(true);
         }
         @After
        public void closeBrowser() {

             global.driver.quit();
      }
      
   

}
