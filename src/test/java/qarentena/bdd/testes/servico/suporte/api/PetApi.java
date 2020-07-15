package qarentena.bdd.testes.servico.suporte.api;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import qarentena.bdd.testes.servico.suporte.dominio.Pet;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={estado}";
    private static final String PET_ENDPOINT = "/v3/pet/{petId}";
    private static final String CRIA_PET_ENDPOINT = "/v3/pet";

    public List<Pet> getByStatus(String status) {
        return given().
            pathParam("estado", status).
        when().
            get(FIND_PETS_BY_STATUS_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK).
            extract().body().jsonPath().getList("", Pet.class);
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

    public void criaAnimal(Pet pet) {
        given().
            body(pet).
        when().
            post(CRIA_PET_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    public void deletaPetsNaoPadrao(String status) {
        List<Integer> petsId = given().
            pathParam("estado", status).
        when().
            get(FIND_PETS_BY_STATUS_ENDPOINT).
        thenReturn().
            path("id");

        List<Integer> manterPets = Arrays.asList(1,2,4,7,8,9,10);

        for (int toDeleteId : petsId) {
            if(!manterPets.contains(toDeleteId)) {
                given().pathParam("petId", toDeleteId).delete(PET_ENDPOINT).then().statusCode(HttpStatus.SC_OK);
            }
        }

    }

}
