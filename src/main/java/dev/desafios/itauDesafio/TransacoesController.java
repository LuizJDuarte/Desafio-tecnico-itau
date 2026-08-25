package dev.desafios.itauDesafio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    private TransacaoService transacaoService;

    public TransacoesController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoDTO transacaoDTO){
        transacaoService.validarTransacao(transacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
