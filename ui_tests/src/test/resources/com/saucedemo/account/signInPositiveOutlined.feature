Feature: Sign In

  Background:
    And I open start page

  @signIn
  Scenario: Valid user sign in
    When I set 'standard_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page

  @signIn
  Scenario: Valid user sign in
    When I set 'problem_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page

  @signIn
  Scenario: Valid user sign in
    When I set 'performance_glitch_user' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page
