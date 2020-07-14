package qarentena.bdd.testes.servico.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import qarentena.bdd.testes.servico.suporte.dominio.Pets;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetStepDefinitions {

    List<Pets> petsAtuais = new ArrayList<>();
    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/pet/findByStatus?status={estado}";
    private static final String PET_ENDPOINT = "/pet/{petId}";
    Response respostaAnimais = null;


    @Dado("que eu possua pets {}")
    public void queEuPossuaPets(String status) {
    }

    @Quando("eu pesquiso por todos os pets {}")
    public void euPesquisoPorTodosOsPetsDisponíveis(String status) {
        petsAtuais = given().
            pathParam("estado", status).
        when().
            get(FIND_PETS_BY_STATUS_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK).
            extract().body().jsonPath().getList("", Pets.class);
    }

    @Então("eu recebo a lista com {} pet(s)")
    public void euReceboAListaComPets(int numeroPetsEsperado) {
        assertThat(petsAtuais.size(), is(numeroPetsEsperado));
    }

    @E("que eu não possua pet {}")
    public void nãoPossuaPetSold(String status) {
        List<Integer> petsId = given().
            pathParam("estado", status).
        when().
            get(FIND_PETS_BY_STATUS_ENDPOINT).
        thenReturn()
            .path("id");

        if(!petsId.isEmpty()) {
            for (Integer id : petsId) {
                given().pathParam("petId", id).delete(PET_ENDPOINT);
            }
        }
    }

    @E("possuo {int} animais com o nome Lion")
    public void possuoAnimaisComONomeLion(int numAnimais) {
        given().
            pathParam("estado", "available").
        when().
            get(FIND_PETS_BY_STATUS_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK).
            body(
                "size()", is(7),
                "findAll { it.name.contains('Lion') }.size()",is(numAnimais),
                "findAll { it.category.name == 'Cats' }.size()",is(2)
            );
    }

    @Quando("eu pesquiso por pets {word}")
    public void euPesquisoPorPetsEstado(String status) {
        respostaAnimais = given().
            pathParam("estado", status).
        when().
            get(FIND_PETS_BY_STATUS_ENDPOINT);

        //pq eh melhor retonar a resposta e não somente o status code
    }

    @Então("eu recebo status {int}")
    public void euReceboStatusHttpStatus(int statusCode) {
        assertThat(respostaAnimais.statusCode(), is(statusCode));
    }

}
