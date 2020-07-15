package qarentena.bdd.testes.servico.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import qarentena.bdd.testes.servico.suporte.api.PedidoApi;
import qarentena.bdd.testes.servico.suporte.api.PetApi;
import qarentena.bdd.testes.servico.suporte.dominio.Pedido;
import qarentena.bdd.testes.servico.suporte.dominio.Pet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class PedidoStepDefinitions {

    PetApi petApi;
    Pet petEsperado;
    Pedido pedidoEsperado;
    PedidoApi pedidoApi;

    public PedidoStepDefinitions() {
        petApi = new PetApi();
        pedidoApi = new PedidoApi();
    }

    @Dado("que eu possua pet(s) {} para compra")
    public void queEuPossuaPets(String status) {
        Pet.Category category = Pet.Category.builder()
                .id(1)
                .name("Dogs")
                .build();

        petEsperado = Pet.builder()
                .id(80)
                .name("skywalker")
                .status(status)
                .category(category)
                .build();

        petApi.criaAnimal(petEsperado);
    }

    @Quando("faço o pedido de um pet")
    public void façoOPedidoDeUmPet() {
        pedidoEsperado = Pedido.builder()
                .id(5)
                .petId(petEsperado.getId())
                .build();

        pedidoApi.criaPedido(pedidoEsperado);
    }

    @Então("o pedido é aprovado")
    public void oPedidoÉAprovado() {
        Pedido pedidoAtual = pedidoApi.pegaPedido(pedidoEsperado.getId());
        assertThat(pedidoAtual, is(pedidoEsperado));
    }
}
