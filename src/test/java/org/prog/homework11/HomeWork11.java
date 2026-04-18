package org.prog.homework11;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.prog.homework11.hmdto.PersonDto;
import org.prog.homework11.hmdto.ResultDto;
import org.prog.session11.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork11 {

    @Test
    public void testRest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", 3);

        Response response = requestSpecification.get();
        ResultDto resultDto = response.as(ResultDto.class);
        ValidatableResponse validatableResponse = response.then();

        validatableResponse.body("results.location[0].StreetDto.number", Matchers.not(Matchers.empty()));
        validatableResponse.body("results.location[0].StreetDto.name", Matchers.not(Matchers.empty()));
        Assert.assertTrue(
                resultDto.getResults()
                        .stream()
                        .anyMatch(r->
                                !r.getLocation().getStreet().getName().equals(null) && !r.getLocation().getStreet().getNumber().equals(null)
                        )
        );

//        for (int i = 0; i < resultDto.getResults().size(); i++) {
//            resultDto.getResults().get(i).getLocation().setPostcode("qwerty");
//        }


        Assert.assertTrue(
                resultDto.getResults()
                        .stream()
                        .anyMatch(r->
                                r.getLocation().getPostcode().matches("\\d+")
                        )
        );

        System.out.println(resultDto);;

    }
}
