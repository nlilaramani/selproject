Feature: User Profile maintenance

  Scenario: Launch user profile page.
    Given user is on the landing page
    When user clicks on  user registration link
    Then user profile page is displayed

  Scenario Outline: Successful submission
    Given user is on the landing page
    When user clicks on  user registration link
    And user enters first name <fname>
    And user enter last name <lname>
    And user submits the page
    Then success page is displayed
    Examples:
      | fname  | lname   |
      | "john" | "smith" |
