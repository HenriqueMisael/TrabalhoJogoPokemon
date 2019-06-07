package main;

import batalha.Jogador;
import batalha.JogadorHumano;
import batalha.JogadorMaquina;

import java.util.function.Function;

public enum TipoJogador {
    MAQUINA(JogadorMaquina::new), HUMANO(JogadorHumano::new);
    private final Function<Integer, Jogador> construtor;

    TipoJogador(Function<Integer, Jogador> construtor) {
        this.construtor = construtor;
    }

    public Jogador get(int id) {
        return this.construtor.apply(id);
    }
}
