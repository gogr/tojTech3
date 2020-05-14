Feature: Log Out

  @logOut
  Scenario: Valid user Log Out
    Given I open start page
    When I set 'standard_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page
    And I click on menu icon on Header
    And I click 'Logout' link on Menu
    Then I am on Sign in page
