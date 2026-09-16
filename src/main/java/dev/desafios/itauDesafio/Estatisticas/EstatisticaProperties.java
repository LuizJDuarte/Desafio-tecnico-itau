package dev.desafios.itauDesafio.Estatisticas;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(

        @Min(value = 1, message = "No mínimo 1 segundo")
        Integer segundos
){}
