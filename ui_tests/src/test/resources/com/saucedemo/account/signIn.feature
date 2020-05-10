Feature: Sign In

  @signIn
  Scenario: Valid user sign in
    Given I open start page
    When I set 'standard_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page

  @signIn
  Scenario: Sign in with invalid password
    Given I open start page
    When I set 'standard_user' as username on Sign in page
    And I set 'thisIsSomeInvalidPassword' as password on Sign in page
    And I click 'Sign In' button on Sign in page expecting failure
    Then Error message 'Epic sadface: Username and password do not match any user in this service' is available on Sign in page
   