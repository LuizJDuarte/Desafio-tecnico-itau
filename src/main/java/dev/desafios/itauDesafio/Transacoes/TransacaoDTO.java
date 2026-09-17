package dev.desafios.itauDesafio.Transacoes;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoDTO {

    @NotNull(message = "O valor da transação é obrigatório: ")
    @Positive(message = "O valor da transação deve ser igual ou maior a 0: ")
    private BigDecimal valor;

    private OffsetDateTime dataHora;
}
