package qarentena.bdd.testes.servico.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import qarentena.bdd.testes.servico.suporte.api.PetApi;
import qarentena.bdd.testes.servico.suporte.dominio.Pet;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetStepDefinitions {

    List<Pet> petAtuais = new ArrayList<>();
    PetApi petApi = new PetApi();
    Response respostaAnimais = null;


    @Dado("que eu possua pet(s) {word}")
    public void queEuPossuaPets(String status) {
    }

    @Quando("eu pesquiso por todos os pets {}")
    public void euPesquisoPorTodosOsPetsDisponíveis(String status) {
        petAtuais = petApi.getByStatus(status);
    }

    @Então("eu recebo a lista com {} pet(s)")
    public void euReceboAListaComPets(int numeroPetsEsperado) {
        assertThat(petAtuais.size(), is(numeroPetsEsperado));
    }

    @E("que eu não possua pet {}")
    public void nãoPossuaPetSold(String status) {
        petApi.deletaTodosPets(status);
    }

    @E("possuo {int} animais {} com o nome {}")
    public void possuoAnimaisComONomeLion(int numAnimais, String estado, String nome) {
        Response resposta = petApi.pegaAnimais(estado);

        resposta.
            then().
                statusCode(HttpStatus.SC_OK).
                body(
                        "size()", is(7),
                        "findAll { it.name.contains('"+nome+"') }.size()",is(numAnimais),
                        "findAll { it.category.name == 'Cats' }.size()",is(2)
                );
    }

    @Quando("eu pesquiso por pets {word}")
    public void euPesquisoPorPetsEstado(String status) {
        respostaAnimais = petApi.pegaAnimais(status);
    }

    @Então("eu recebo status {int}")
    public void euReceboStatusHttpStatus(int statusCode) {
        assertThat(respostaAnimais.statusCode(), is(statusCode));
    }
}
