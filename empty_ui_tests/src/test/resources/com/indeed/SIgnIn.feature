Feature: Sign In

  Scenario: Sign In as Indeed user
    When I open Job Search Page
    And I click log in link on Job Search page
    And I set shamsudinovmukhamad@gmail.com as username on Login page
    And I set 12qw34eR@ as password on Login page
    And I click Sign in button on Login page
    Then I am signed in as shamsudinovmukhamad@gmail.com user on Job Search Page


