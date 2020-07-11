package qarentena.bdd.testes.servico.suporte.client;

import org.apache.http.HttpStatus;
import qarentena.bdd.testes.servico.suporte.dominio.Pets;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetRestClient {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={status}";
//    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus";
//    param("status", status).

    public List<Pets> getPetsByStatus(String status) {
        return given().
            pathParam("status", status).
        when().
            get(FIND_PETS_BY_STATUS_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK).
        extract().body().jsonPath().getList("", Pets.class);
    }

}
