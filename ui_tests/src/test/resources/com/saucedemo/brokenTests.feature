Feature: Mixed Broken Tests

  Scenario: Positive sign in test with standard_user
    Given I open start page
    When I set 'standard_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page

  Scenario: Positive sign in test with performance_glitch_user
    Given I open start page
    When I set 'performance_glitch_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page

  Scenario: Positive sign in test with problem_user
    Given I open start page
    When I set 'problem_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page

  Scenario Outline: Sign in as <user> user
    Given I open start page
    When I set '<user>' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page

    Examples:
      | user                    |
      | problem_user            |
      | performance_glitch_user |

  Scenario: Add two T-Shirts to cart
    Given I open start page
    And I set 'standard_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page
    When I click 'ADD TO CART' button on 'Sauce Labs Bolt T-Shirt' product on Products page
    And I click 'ADD TO CART' button on 'Test.allTheThings() T-Shirt (Red)' product on Products page
    When I click on cart icon on Header
    Then Cart contains '2' items on Header


  Scenario: Sign out from cart your information page
    Given I open start page
    And I set 'standard_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page
    And I click 'ADD TO CART' button on 'Sauce Labs Bolt T-Shirt' product on Products page
    And I click on cart icon on Header
    And I click 'Checkout' button on Cart page
    And I click on menu icon on Header
    When I click 'Logout' link on Menu
    Then I am on Sign in page

  Scenario: Purchase Bike Light
    Given I open start page
    And I set 'standard_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page
    And I click 'ADD TO CART' button on 'Sauce Labs Bike Light' product on Products page
    When I click on cart icon on Header
    And I click 'Checkout' button on Cart page
    And I set 'John' as first name on Checkout your information page
    And I set 'Smith' as last name on Checkout your information page
    And I set '11235' as zip on Checkout your information page
    And I click 'Continue' button on Checkout your information page
    And Item total is '9.99' on Checkout overview page
    And Tax is '0.80' on Checkout overview page
    And Total is '10.79' on Checkout overview page
    And I click 'Finish' button on Checkout overview page
    Then I am on Checkout complete page

