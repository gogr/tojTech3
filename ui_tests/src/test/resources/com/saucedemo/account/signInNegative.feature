Feature: Sign In with Invalid Data

  @signInNegative
  Scenario: Invalid username sign in
    Given I open start page
    When I set 'muxxa_26' as username on Sign in page
    And I set 'secret_sauce' as password on Sign in page
    And I click 'Sign In' button on Sign in page expecting failure
    Then Error message 'Epic sadface: Username and password do not match any user in this service' is available on Sign in page


  @signInNegative
  Scenario: Sign in with invalid password
    Given I open start page
    When I set 'standard_user' as username on Sign in page
    And I set 'thisIsSomeInvalidPassword' as password on Sign in page
    And I click 'Sign In' button on Sign in page expecting failure
    Then Error message 'Epic sadface: Username and password do not match any user in this service' is available on Sign in page


    @signInNegative
    Scenario: Invalid password and username
      Given I open start page
      When I set 'shfsdghd' as username on Sign in page
      And I set 'thisIsSomeInvalidPassword' as password on Sign in page
      And I click 'Sign In' button on Sign in page expecting failure
      Then Error message 'Epic sadface: Username and password do not match any user in this service' is available on Sign in page


     @signInNegative
     Scenario Outline: Invalid password or username
       Given I open start page
       When I set '<username>' as username on Sign in page
       And I set '<password>' as password on Sign in page
       And I click 'Sign In' button on Sign in page expecting failure
       Then Error message '<error mesage>' is available on Sign in page

       Examples:
       |username   |password | error mesage |
       | standart_user ||          Epic sadface: Password is required          |
       ||   secret_sauce   | Epic sadface: Username is required                |
       | locked_out_user  |  secret_sauce    | Epic sadface: Sorry, this user has been locked out.|



