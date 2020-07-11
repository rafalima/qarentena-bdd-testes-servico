package qarentena.bdd.testes.servico.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import qarentena.bdd.testes.servico.suporte.client.PetRestClient;
import qarentena.bdd.testes.servico.suporte.dominio.Pets;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PetsStepDefinitions {

    List<Pets> petsAtuais = new ArrayList<>();

    @Dado("que eu possua pets {} para a venda")
    public void queEuPossuaPetsParaAVenda(String status) {
    }

    @Quando("eu pesquiso por todos os pets {}")
    public void euPesquisoPorTodosOsPetsDisponíveis(String status) {
        PetRestClient petRestClient = new PetRestClient();
        petsAtuais = petRestClient.getPetsByStatus(status);
    }

    @Então("eu recebo a lista de pets disponíveis")
    public void euReceboAListaDePetsDisponíveis() {
        assertThat(petsAtuais.size(), is(7));
    }

    @Então("eu recebo a lista com {int} pets")
    public void euReceboAListaComPets(int numeroPetsEsperado) {
        assertThat(petsAtuais.size(), is(numeroPetsEsperado));
    }
}
