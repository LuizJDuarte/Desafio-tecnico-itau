package dev.desafios.itauDesafio;

import org.springframework.stereotype.Repository;

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
}
