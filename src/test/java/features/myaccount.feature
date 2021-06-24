Feature: My Account functionalities

  Background:
    Given The user logs into the application with username "test_user@test.com" and password "1234"

  @Smoke
  Scenario: Empty wishlist
    When The user goes to his wishlist option
    Then Empty wishlist message should be displayed

  @Smoke
  Scenario: Verify the edit info functionality
    When The user goes to his edit information option
    And Fills the information with random data
    Then The app should redirect to my account page
    And A success edit info message should appear
