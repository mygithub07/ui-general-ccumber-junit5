package com.test.stepdefs;

import com.google.inject.Inject;
import com.test.support.Global;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class SecondIT {
    
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
       
         @And("perform guice test" )
                 public void guiceTest(){
               System.out.println(global.help.guiceTest());
                 }
                 
}
