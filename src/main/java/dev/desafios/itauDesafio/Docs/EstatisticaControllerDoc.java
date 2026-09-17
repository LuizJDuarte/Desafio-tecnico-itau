package dev.desafios.itauDesafio.Docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name="Estatistica",
        description = "Endpoints responsaveis por retornar as estatísticas das transaçoes"
)
public interface EstatisticaControllerDoc {

    @Operation(summary = "Retorna estatísticas das transações",
            description = "Retorna as estatísticas das transações feitas no período de 60 segundos"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Estatísticas da transação geradas com sucesso"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro inesperado no servidor"
    )
    ResponseEntity<Void> estatistica();
}
