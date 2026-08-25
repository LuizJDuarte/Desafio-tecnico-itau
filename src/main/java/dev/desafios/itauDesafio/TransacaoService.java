package dev.desafios.itauDesafio;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoDTO transacaoDTO){
        // Valor maior ou igual a 0
        if(transacaoDTO.getValor().compareTo(BigDecimal.ZERO) < 0 ){
            // Transação não válida
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, uma transação deve ser maior que ou igual a 0");
        }

        // Data menor ou igual a Data de hoje
        if (transacaoDTO.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Na data da transação");
        }

        // Data presente
        if(transacaoDTO.getDataHora() == null){
            throw new NullPointerException("Erro: Data nula");
        }

        // Valor presente
        if(transacaoDTO.getValor() == null){
            throw new NullPointerException("Erro: Valor nulo");
        }
    }
}
