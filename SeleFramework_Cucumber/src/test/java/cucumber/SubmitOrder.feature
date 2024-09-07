@tag
Feature: Purchase the order in Ecommerce order
 

  Background:
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: positive test for submitting order in Ecommerce website
    Given Logged in with username <name> and password <password>
    When I add product "<productName>" to Cart
    And Checkout "<productName>" and submit the order
    Then  "THANKYOU FOR THE ORDER." is displayed on the confirmation page

    Examples: 
      |name|password|productName|
      |shishira@gmail.com|Shishira@123|ZARA COAT 3|
     
