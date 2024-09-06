
@tag
Feature: Error validations
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given I landed on Ecommerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email  password." message is displayed  

    Examples: 
      |name|password| 
      |shishir@gmail.com|Shishira@123|
    
