Feature: Sign In

  Background:
  And I open start page

  @signIn
  Scenario Outline: Verify <username> user name sign in with <password> password
    When I set '<username>' as username on Sign in page
    And I set '<password>' as password on Sign in page
    And I click 'Sign In' button on Sign in page
    Then I am on Products page

    Examples:

    | username               | password     |
    | standard_user          | secret_sauce |
    | problem_user           | secret_sauce |
    | performance_glitch_user| secret_sauce |