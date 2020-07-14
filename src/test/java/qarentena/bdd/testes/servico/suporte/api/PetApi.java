package qarentena.bdd.testes.servico.suporte.api;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import qarentena.bdd.testes.servico.suporte.dominio.Pets;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/pet/findByStatus?status={estado}";
    private static final String PET_ENDPOINT = "/pet/{petId}";

    public List<Pets> getByStatus(String status) {
        return given().
            pathParam("estado", status).
        when().
            get(FIND_PETS_BY_STATUS_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK).
            extract().body().jsonPath().getList("", Pets.class);
    }

    public void deletaTodosPets(String status) {
        List<Integer> petsId = given().
                pathParam("estado", status).
            when().
                get(FIND_PETS_BY_STATUS_ENDPOINT).
            thenReturn().
                path("id");

        if(!petsId.isEmpty()) {
            for (Integer id : petsId) {
                given().pathParam("petId", id).delete(PET_ENDPOINT).then().statusCode(HttpStatus.SC_OK);
            }
        }
    }

    public Response pegaAnimais(String estado) {
        return given().
               pathParam("estado", estado).
            when().
                get(FIND_PETS_BY_STATUS_ENDPOINT);
    }

}
