package dev.desafios.itauDesafio.Transacoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController {

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
            log.error("Erro em uma validação de BAD REQUEST");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity deletar(){
        log.info("Deletando dados: ");
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
        }
}
