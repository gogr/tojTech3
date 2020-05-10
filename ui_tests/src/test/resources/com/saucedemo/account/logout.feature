Feature: Logout

@logout_feature
Scenario: Logout
Given I open start page
  When I set 'standard_user' as username on Sign in page
  And I set 'secret_sauce' as password on Sign in page
  And I click 'Sign In' button on Sign in page
  Then I am on Products page
  When I click on menu icon on Header
  And I click 'Logout' link on Menu
  Then I am on Sign in page
