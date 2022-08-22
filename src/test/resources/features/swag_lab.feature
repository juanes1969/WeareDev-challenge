#author: Juan Esteban Olaya

Feature: Try swag lab page
  I as a tester
  I want to test the login module and the checkout module
  for the swag lab page


  Background:
    Given User login in the swag lab page
     ##@externaldata@./src/test/resources/data/data.xlsx@Test

  @LoginUser
  Scenario: successful login
    Then Validate application login


  @CreateTheOrderUser
  Scenario: Successful purchase verification
    When the user adds a product to the cart
    And goes to enter your payment information
    ##@externaldata@./src/test/resources/data/data.xlsx@Test
    And and check the summary of your purchase
    Then Verify successful delivery order message created