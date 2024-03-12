package org.prog.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.dto.PersonDto;
import org.prog.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;

public class RestTests {

    //https://randomuser.me/api/?inc=gender,name,nat,id&noinfo
    //TODO: Add IdDto class (describing "id" field of a person)
    // add new Dto to existing PersonDto class
    // print "name" and "value" from IdDto

    List<PersonDto> personDtoList = new ArrayList<>();

    @Test
    public void getRandomPersonTest() {
        RestAssured.baseURI = "https://randomuser.me/";
        RequestSpecification rs = RestAssured.given()
                .header("X-Client", "prog qutomation")
                .body("reqeust body")
                .queryParam("inc", "gender,name,nat,id")
                .queryParam("noinfo")
                .queryParam("results", 10)
                .basePath("api/");
        rs.auth().basic("user", "password");

        Response r = rs.get();

        r.prettyPrint();

        r.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(containsString("gender"));

        ResultsDto dto = r.as(ResultsDto.class);
        System.out.println(dto.getResults().size());
        Assert.assertEquals(dto.getResults().size(), 10);
        boolean anyFemalePresent = false;
        for (PersonDto p : dto.getResults()) {
            if (p.getGender().equals("female")) {
                anyFemalePresent = true;
                break;
            }
        }
        Assert.assertTrue(anyFemalePresent, "No males found");
        System.out.println("-------------------------");

        personDtoList = dto.getResults();
    }

    @Test
    public void getRandomId() {
        RestAssured.baseURI = "https://randomuser.me/";
        RequestSpecification rs = RestAssured.given()
                .header("X-Client", "prog qutomation")
                .body("reqeust body")
                .queryParam("inc", "gender,name,nat,id")
                .queryParam("noinfo")
                .queryParam("results", 10)
                .basePath("api/");
        rs.auth().basic("user", "password");

        Response response = rs.get();

        ResultsDto dto = response.as(ResultsDto.class);
        for (PersonDto p : dto.getResults()) {
            System.out.println(p.getId().getName() + " " + p.getId().getValue());

        }
    }
}