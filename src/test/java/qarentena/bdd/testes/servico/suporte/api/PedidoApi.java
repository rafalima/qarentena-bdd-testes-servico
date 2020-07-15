package qarentena.bdd.testes.servico.suporte.api;

import org.apache.http.HttpStatus;
import qarentena.bdd.testes.servico.suporte.dominio.Pedido;

import static io.restassured.RestAssured.given;

public class PedidoApi {

    private static final String CRIA_PEDIDO_ENDPOINT = "/store/order";
    private static final String PEDIDO_ENDPOINT = "/store/order/{orderId}";

    public void criaPedido(Pedido pedido) {
        given().
            body(pedido).
        when().
            post(CRIA_PEDIDO_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    public Pedido pegaPedido(int id) {
        return given().
            pathParam("orderId",id).
        when().
            get(PEDIDO_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK).
            extract().body().as(Pedido.class);
    }


}
