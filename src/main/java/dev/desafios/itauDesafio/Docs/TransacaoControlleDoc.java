package dev.desafios.itauDesafio.Docs;

import dev.desafios.itauDesafio.Transacoes.TransacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="Transaçoes",
        description = "Endpoints responsaveis por criar e adicionar as transacoes em uma lista assim como limpa-la"
)
public interface TransacaoControlleDoc {

    @Operation(summary = "Cria uma transação",
            description = "Recebe uma transação válida, e adiciona em uma lista"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Transação criada com sucesso"
    )
    @ApiResponse(
            responseCode = "422",
            description = "Erro de validação capturado"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro inesperado no servidor"
    )
    ResponseEntity<Void> adicionar(@RequestBody TransacaoDTO transacaoDTO);


    @Operation(summary = "Deleta uma transação",
            description = "Deleta todas as transaçoes adicionadas em uma lista"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Todas as transações foram deletadas"
    )
    ResponseEntity<Void> deletar();

}
