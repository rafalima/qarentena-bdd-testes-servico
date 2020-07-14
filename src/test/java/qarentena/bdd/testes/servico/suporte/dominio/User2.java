package qarentena.bdd.testes.servico.suporte.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
public class User2 {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

}
