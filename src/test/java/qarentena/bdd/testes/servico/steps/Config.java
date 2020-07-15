package qarentena.bdd.testes.servico.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import qarentena.bdd.testes.servico.suporte.api.PetApi;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class Config {

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "http://localhost:12345";
        basePath = "/api";

        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization", getToken()).
                setContentType(ContentType.JSON).
                build();


        RestAssured.responseSpecification = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                build();
    }

    @After("@DeletaPetsExtra")
    public void deletePetsExtra() {
        PetApi petApi = new PetApi();
        petApi.deletaPetsNaoPadrao("available");
    }

    private String getToken() {
        return "libera-ae";
    }
}
