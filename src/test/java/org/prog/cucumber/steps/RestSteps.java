package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.prog.dto.NameDto;
import org.prog.dto.ResultsDto;
import org.prog.util.DataHolder;

public class RestSteps {

    @Given("I retrieve a random user from API as {string}")
    public void retrieveRandomUser(String alias) {
        RestAssured.baseURI = "https://randomuser.me/";
        ResultsDto dto = RestAssured.given()
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .basePath("api/")
                .get()
                .as(ResultsDto.class);

        NameDto name = dto.getResults().get(0).getName();
        DataHolder.getInstance().put(alias, name.getFirst() + " " + name.getLast());
        System.out.println("Stored user : " + DataHolder.getInstance().get(alias));
    }
}
