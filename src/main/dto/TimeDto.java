package main.dto;

import main.TipoJogador;

import java.util.List;

public class TimeDto {

    public final TipoJogador tipoJogador;
    public final List<PokemonDto> pokemons;

    public TimeDto(TipoJogador tipoJogador, List<PokemonDto> pokemons) {
        this.tipoJogador = tipoJogador;
        this.pokemons = pokemons;
    }
}
