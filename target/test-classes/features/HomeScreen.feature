Feature: General Store App
 
  Scenario Outline: User navigates to the product screen
    Given Open the app
    And I click the country dropdown
    Then I select "<country>" from the dropdown
    And I enter the name "<name>"
    When I click the Let's go button
    Then the product screen should be visible

    Examples: 

      | country | India |

      | name   | Aishwarya |

      | Liberia | john |
 