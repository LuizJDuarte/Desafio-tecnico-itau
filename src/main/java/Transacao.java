import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    private BigDecimal valor; // Contexto da área financeira (precisão financeira)
    private OffsetDateTime dataHora; // Já que estamos tratando de fuso horário
}
