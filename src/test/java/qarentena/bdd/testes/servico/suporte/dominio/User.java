package qarentena.bdd.testes.servico.suporte.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class User {
    @Builder.Default
    int id = 10;
    @Builder.Default
    String username = "rafalima";
    @Builder.Default
    String firstName = "Rafael";
    @Builder.Default
    String lastName = "Lima";
    @Builder.Default
    String email= "rafael@email.com";
    @Builder.Default
    String password = "12345";
    @Builder.Default
    String phone = "8199999999" ;
    @Builder.Default
    int userStatus = 1;

}
