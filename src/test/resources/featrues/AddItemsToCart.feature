Feature: Adding Items to the Cart Functionality
  In order to buy items form the site
  As a user in the site
  I want to add/remove items form the cart

  Scenario: Adding one item to the cart
    Given  I logged in with
      | standard_user | secret_sauce |
    When  Adding an item to the cart
      | Sauce Labs Backpack |
    Then I should see the number of items on the cart icon become
      | 1 |

  Scenario: Adding two items to the cart
    Given I logged in with
      | standard_user | secret_sauce |
    When Adding an item to the cart
      | Sauce Labs Backpack |
    And Adding another item to the cart
      | Sauce Labs Bike Light |
    Then I should see the number of items on the cart icon become
      | 2 |

  Scenario: Adding one item to the cart then remove it
    Given I logged in with
      | standard_user | secret_sauce |
    When Adding an item to the cart
      | Sauce Labs Bolt T-Shirt |
    And Removing it from the cart
      | Sauce Labs Bolt T-Shirt |
    Then I should see the cart empty

  Scenario: Adding tow items to the cart then remove one
    Given I logged in with
      | standard_user | secret_sauce |
    When Adding an item to the cart
      | Sauce Labs Backpack |
    And Adding another item to the cart
      | Sauce Labs Bike Light |
    And Removing it from the cart
      | Sauce Labs Bike Light |
    Then I should see the number of items on the cart icon become
      | 1 |

  Scenario: Adding an item to the cart then logout and login
    Given I logged in with
      | standard_user | secret_sauce |
    When Adding an item to the cart
      | Sauce Labs Backpack |
    And Logging out
    And Logging in with
      | standard_user | secret_sauce |
    Then I should see the number of items on the cart icon become
      | 1 |