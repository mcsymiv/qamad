Feature: Check SwapApi

  @api
  Scenario: Check swapapi response value
    Given I send GET request to /starships/9/ endpoint with 9 value
    Then I check that response is returned with 200 status code
    Then I check that response body contains name field with Death Star value
