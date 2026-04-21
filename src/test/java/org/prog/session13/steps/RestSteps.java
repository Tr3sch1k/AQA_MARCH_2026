package org.prog.session13.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.prog.session11.dto.ResultsDto;

public class RestSteps {

    @Given("I request {int} random people from randomuser.me API as {string}")
    public void requestRandomPeople(int amount, String alias) {
        ResultsDto dto = RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .queryParam("results", amount)
                .get()
                .as(ResultsDto.class);
        DataManager.DATA.put(alias, dto);
    }
}
