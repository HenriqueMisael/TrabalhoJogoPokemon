package main;

import batalha.Batalha;
import batalha.Jogador;
import main.dto.SimulacaoDto;
import main.dto.TimeDto;
import pokemon.Pokemon;

import java.util.Arrays;
import java.util.LinkedList;

public class TrabalhoJavaPokemon {

    public static void main(String[] args) {

        Batalha batalha;

        SimulacaoDto simulacaoDto = SimulacaoDto.get(new LinkedList<>(Arrays.asList(args)));

        batalha = new Batalha(getJogador(simulacaoDto.timeUm, 1), getJogador(simulacaoDto.timeDois, 2));
        batalha.start();
    }

    private static Jogador getJogador(TimeDto timeUm, int i) {
        Jogador p1;
        p1 = timeUm.tipoJogador.get(i);
        timeUm.pokemons.forEach(dto -> p1.adicionarPokemon(Pokemon.fromDto(dto)));
        return p1;
    }
}
