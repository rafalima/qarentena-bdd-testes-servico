package qarentena.bdd.testes.servico.suporte.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private int id;
    private String name;
    private Category category;
    private String status;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Category {
        private int id;
        private String name;
    }
}
