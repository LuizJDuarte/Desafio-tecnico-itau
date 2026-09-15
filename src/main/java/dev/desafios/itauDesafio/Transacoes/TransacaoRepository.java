package dev.desafios.itauDesafio.Transacoes;

import dev.desafios.itauDesafio.Estatisticas.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoDTO> listaDeTransacoes = new ArrayList<>();

    // salvar os dados em uma lista
    public void salvarDados(TransacaoDTO transacaoDTO){
        listaDeTransacoes.add(transacaoDTO);
    }

    // Apagar essa lista depois de 60 segundos
    public void limparDados(TransacaoDTO transacaoDTO){

    }

    // Apagar todas as transações da lista
    public void deletarDados(){
        listaDeTransacoes.clear();
    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial){

        if (listaDeTransacoes.isEmpty()){
            return new EstatisticaDTO(0,0.0,0.0,0.0,0.0);
        }

        // Transformar a lista de transações em números para fazer a operação
        final var summary = listaDeTransacoes.stream()
                .filter(t ->
                            t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial)
                        )
                .mapToDouble(t-> t.getValor().doubleValue())
                .summaryStatistics();

                return new EstatisticaDTO(
                        summary.getCount(), summary.getSum(), summary.getAverage(), summary.getMin(), summary.getMax());
    }
}
