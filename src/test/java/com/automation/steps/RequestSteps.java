package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
public class RequestSteps {
    @Given("user calls {string} endpoint")
    public void user_calls_endpoint(String endPoint) {
        if (endPoint.contains("@")) {
            String resourceId = ConfigReader.getConfigValue("resource.id");
            endPoint = endPoint.replace("@id", resourceId);
        }
        RestAssuredUtils.setEndPoint(endPoint);
    }
    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }
    @Given("set request body from the file {string}")
    public void set_request_body_from_the_file(String fileName) {
        RestAssuredUtils.setBody(fileName);
    }
    @When("user performs post call")
    public void user_performs_post_call() {
        RestAssuredUtils.post();
    }
    @When("user performs get call")
    public void user_performs_get_call() {
        RestAssuredUtils.get();
    }

}

