Feature: Second test feature

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
 