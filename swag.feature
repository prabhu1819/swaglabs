Feature: - To test the login functionality and product purchase of the specific users

  @smoke
  Scenario Outline: To check the login feature of the Site
    Given User is on the login page
    When User enters the Valid <username> and <password>
    And User clicks on Login button
    Then User navigates to the Homepage
    And User applies the filter and selects the products and add to cart
    Then User moves to cart and clicks on continue shopping and user navigates to the home page
    And User selects another product and moves to cart
    When user clciks on checkout Add info form opens and user fills the <firstname> <lastname> and <zipcode>
    And User clicks on continue and invoice is generated
    Then User clicks on finish and logs out
    Examples: 
      | username                | password     | firstname | lastname | zipcode |
      | standard_user           | secret_sauce | jeet      | amnur    |  413102 |
      | locked_out_user         | secret_sauce | om        | deokate  |  413103 |
      | problem_user            | secret_sauce | rutuja    | mali     |  413104 |
      | performance_glitch_user | secret_sauce | parth     | malik    |  413105 |
