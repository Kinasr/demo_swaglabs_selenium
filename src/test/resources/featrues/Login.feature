Feature: Login Functionality
  In order to see items in SWAGLABS site
  As a user for the site
  I want to login successfully

  Scenario Outline: Login Successful
    Given I am in the login page of the SWAGLABS site
    When I enter a <username> and a <password>
    Then I should be taken to the Home Page with <title>

    Examples:
      | username                  | password       | title      |
      | "standard_user"           | "secret_sauce" | "PRODUCTS" |
      | "problem_user"            | "secret_sauce" | "PRODUCTS" |
      | "performance_glitch_user" | "secret_sauce" | "PRODUCTS" |


  Scenario Outline: Login With Invalid data
    Given I am in the login page of the SWAGLABS site
    When I enter a <username> and a <password>
    Then I will get a meaningful <errorMessage>

    Examples:
      | username          | password         | errorMessage                                                                |
      | "locked_out_user" | "secret_sauce"   | "Epic sadface: Sorry, this user has been locked out."                       |
      | "wrong username"  | "wrong password" | "Epic sadface: Username and password do not match any user in this service" |
      | "standard_user"   | "wrong password" | "Epic sadface: Username and password do not match any user in this service" |
      | "wrong username"  | "secret_sauce"   | "Epic sadface: Username and password do not match any user in this service" |
      | ""                | ""               | "Epic sadface: Username is required"                                        |
      | "empty password"  | ""               | "Epic sadface: Username is required"                                        |
      | ""                | "empty username" | "Epic sadface: Password is required"                                        |