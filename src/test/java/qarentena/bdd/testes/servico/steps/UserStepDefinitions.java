package qarentena.bdd.testes.servico.steps;

import io.cucumber.docstring.DocString;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import qarentena.bdd.testes.servico.suporte.dominio.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserStepDefinitions {

    private Map<String, String> userEsperadoMapa = new HashMap<>();
    private Response responseReal;
    private User userEsperado;

    private static final String CRIAR_USER_ENDPOINT = "/user";
    private static final String USER_ENDPOINT = "/user/{nome}";


    @Quando("eu faço um POST para {} com o seguintes valores:")
    public void euFaçoUmPOSTParaUserComOSeguintesValores(String endpoint, Map<String, String> user) {
        userEsperadoMapa = user;

        given().
            body(user).
        when().
            post(endpoint).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    @Então("quando faço um GET para {} então o usuário criado é retornado")
    public void quandoFaçoUmGETParaUserEntãoVejoOPetCriado(String endpoint) {
        when().
            get(endpoint).
        then().
            statusCode(HttpStatus.SC_OK).
            body("username", is(userEsperadoMapa.get("username")));
    }

    @Quando("crio um user")
    public void crioUmUser() {
       userEsperado = User.builder().build();

        responseReal = given().
            body(userEsperado).
        when().
            post(CRIAR_USER_ENDPOINT);
    }

    @Então("recebo status code {int}")
    public void receboStatusCode(int statusCode) {
        assertThat(responseReal.statusCode(), is(statusCode));
    }

    @E("o user criado foi cadastrado")
    public void oUsuarioCriadoFoiCadastrado() {
        User user = given().
            pathParam("nome", userEsperado.getUsername()).
        when().
            get(USER_ENDPOINT).
        thenReturn().as(User.class);

        assertThat(userEsperado, is(user));

    }
}
