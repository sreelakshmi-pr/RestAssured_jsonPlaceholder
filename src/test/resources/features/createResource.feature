Feature:
  Scenario: Create resource
    Given user calls "/posts" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "createResource.json"
    When user performs post call
    Then verify status code is 201
    And verify resource id is not empty
    And stores created resource id into "resource.id"
    When user calls "/posts/@id" endpoint
    And set header "Content-Type" to "application/json"
    When user performs get call
    Then verify status code is 201
