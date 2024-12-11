Feature: Send data

  @Post

  Scenario Outline: Send data

    When the user sends a request using the '<endPoint>' with '<name>' '<email>' and '<age>'
    Then validates the '<code>' response
    And validates the expected '<id>'

    Examples:
      | endPoint | name   | email             | age | code | id  |
##@externaldata@parameters/InputData.xlsx@InputData
      | /posts   | Steven | jslv312@gmail.com | 24  | 201  | 101 |