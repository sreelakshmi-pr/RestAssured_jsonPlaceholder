package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
public class ResponseStep {
    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode,RestAssuredUtils.getStatusCode());
    }
    @Then("verify resource id is not empty")
    public void verify_resource_id_is_not_empty() {
        String resourceId=RestAssuredUtils.getResponseFieldValue("id");
        Assert.assertTrue(!resourceId.isEmpty());
    }
    @Then("stores created resource id into {string}")
    public void stores_created_resource_id_into(String key) {
        ConfigReader.setConfigValue(key,RestAssuredUtils.getResponseFieldValue("id"));
    }
}
