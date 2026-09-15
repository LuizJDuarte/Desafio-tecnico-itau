package dev.desafios.itauDesafio.Estatisticas;

import dev.desafios.itauDesafio.Transacoes.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/estatística")
public class EstatisticasController {

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public ResponseEntity estatistica(){
    // Log  de requisicao criado via lombok
        log.info("Calculando estatisticas de transacoes");

    // Calcular quantas transações acontecem em N segundos
        final var horaInicial = OffsetDateTime
                .now()
                .minusSeconds(estatisticaProperties.segundos());


        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }

}
