package dev.desafios.itauDesafio.Estatisticas;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(

        @NotNull(message = "No mínimo 1 segundo")
        Integer segundos
){}
