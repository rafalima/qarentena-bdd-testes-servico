package qarentena.bdd.testes.servico.suporte.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Pedido {
    private int id;
    private int petId;
    @Builder.Default
    private int quantity = 1;
    private String shipDate;
    private String status;
    private boolean complete;
}
