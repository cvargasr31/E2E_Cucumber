Feature: Register into the app

  @Regression
  Scenario: Register with valid data
    Given The users go to the register form
    When The user fills the form "Carlos" "Vargas" "123456" "pwd123" "pwd123"
    Then The register success message is displayed

  @Smoke
  Scenario Outline: User attempts to register missing a field value
    Given  The users go to the register form
    When The user fills the form with invalid data <First Name> <Last Name> <Email> <Phone> <Password> <Password Confirm>
    Then The error message is displayed
    Examples:
      | First Name   | Last Name            |Email          | Phone  | Password  | Password Confirm |
      |              | Vargas               |cvr@test.com   |123456  | pwd123    |pwd123            |
      | Juan         |                      |cvr@test.com   |555444  |contra444  |contra4444        |
      | Rodrigo      | Benavides            |               |999122  |clave_123  |clave_123         |
      | Humberto     | Cisneros             |cvr@test.com   |        |clave_123  |clave_123         |
      | Jaime        | Topo                 |cvr@test.com   |999122  |           |clave_123         |
      | Miguel       | Quispe               |cvr@test.com   |999122  |clave_123  |                  |