Feature: Validating Add Place API

  Scenario Outline: Verify if place is being added successfully using AddPlaceAPI
  
    Given Add place payload "<name>" "<Language>" "<address>"
    When user calls AddPlaceAPI with POST HTTP request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    

  Examples:
    |name| Language| address|
    |tree new york house| English| Times Square|
    |B new house| English| Beverly Hills Square|
    
    