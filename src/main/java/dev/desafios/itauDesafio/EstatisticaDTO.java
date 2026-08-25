package dev.desafios.itauDesafio;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EstatisticaDTO {
    private final long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;


}
