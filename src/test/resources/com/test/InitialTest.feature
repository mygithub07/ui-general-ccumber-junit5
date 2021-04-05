Feature: Initial Integration test feature

   Scenario Outline: test long type
     Given I log the type of <id> 
  
      Examples:
        |id|
        |  41  |
   Scenario Outline: example
    Given I log <TestString>
    And perform guice test 
      Examples:
        |TestString|
        |"                   " |
  
 #   Scenario Outline: Add a user and validate the user has been added to the table
        
     
 #      Given I open the site "http://www.way2automation.com/angularjs-protractor/webtables/"
  #      And perform guice test 
 #      When I add  user with the following information <FirstName> <LastName> <username> <password> <Email> <CellPhone>
 #       Then I see user <username> added to the table
  #      Examples:
  #      |FirstName|LastName|username| password|Email|CellPhone|
  #      |"TestFirstName" |"TestLastName" | "testusername"  |"test12345"|"testuser@testcompany.com"|"123-456-7890"|
  #      |"TestFirstName2" |"TestLastName2" | "testusername2"  |"test6789"|"testuser2@testcompany2.com"|"456-789-1234"|
  
  # Scenario: Add a user using pojo class in a scenario
     #  Given I open the site "http://www.way2automation.com/angularjs-protractor/webtables/"
    #   When I add  user with passing info to pojo class
     #   |FirstName|LastName|username| password|Email|CellPhone|
    #    |TestFirstName3 |TestLastName3 | testusername3  |test67890|testuser3@testcompany3.com|456-789-1122|
      
  
 Scenario Outline: Add a user using pojo class in scenario outline
   
       Given I open the site "http://www.way2automation.com/angularjs-protractor/webtables/"
       When I add  user with passing info to pojo class from scenario outline <FirstName> <LastName> <username> <password> <Email> <CellPhone>
        # |<FirstName>|<LastName>|<username>| <password>|<Email>|<CellPhone>|
        Then I see user <username> added to the table
        Examples:
        |FirstName|LastName|username| password|Email|CellPhone|
        |"TestFirstName3" |"TestLastName3" | "testusername3"  |"test67890"|"testuser3@testcompany3.com"|"456-789-1122"|
  
  # Scenario Outline: Delete user and validate user has been deleted

 #        When I delete <username>
  #       Then user <username> is deleted

 #        Examples:
 #        |username|
 #        | "Novak" |
