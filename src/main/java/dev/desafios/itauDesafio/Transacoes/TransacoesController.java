package dev.desafios.itauDesafio.Transacoes;

import dev.desafios.itauDesafio.Docs.TransacaoControlleDoc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController implements TransacaoControlleDoc {

    private TransacaoService transacaoService;
    private TransacaoRepository transacaoRepository;

    public TransacoesController(TransacaoService transacaoService, TransacaoRepository transacaoRepository) {
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoDTO transacaoDTO){
        try{
            log.info("Validando transação e salvando dados: ");
            transacaoService.validarTransacao(transacaoDTO);
            transacaoRepository.salvarDados(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception){
            log.error("Erro em uma ou mais validações, tente novamente: ");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception exception){
            log.error("Erro no servidor, tente novamente: ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity deletar(){
        log.info("Deletando lista de transações: ");
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
        }
}
