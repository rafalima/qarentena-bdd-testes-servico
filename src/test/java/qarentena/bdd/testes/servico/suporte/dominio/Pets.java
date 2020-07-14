package qarentena.bdd.testes.servico.suporte.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Pets {
    private String name;
    private Category category;


    @Getter
    public static class Category {

        private int id;
        private String name;

    }

}
