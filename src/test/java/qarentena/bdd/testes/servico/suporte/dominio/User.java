package qarentena.bdd.testes.servico.suporte.dominio;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    @Builder.Default
    private int id = 10;
    @Builder.Default
    private String username = "rafalima";
    @Builder.Default
    private String firstName = "Rafael";
    @Builder.Default
    private String lastName = "Lima";
    @Builder.Default
    private String email= "rafael@email.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "8199999999" ;
    @Builder.Default
    private int userStatus = 1;

}
