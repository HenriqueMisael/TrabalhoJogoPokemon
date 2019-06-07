package main.dto;

import main.TipoJogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.function.Supplier;

import static java.lang.Integer.valueOf;

public class SimulacaoDto {

    public final TimeDto timeUm;
    public final TimeDto timeDois;

    private SimulacaoDto(TimeDto timeUm, TimeDto timeDois) {
        this.timeUm = timeUm;
        this.timeDois = timeDois;
    }

    public static SimulacaoDto get(Queue<String> args) {
        return new SimulacaoDto(proximoTime(args), proximoTime(args));
    }

    private static TimeDto proximoTime(Queue<String> args) {
        return new TimeDto(TipoJogador.valueOf(args.remove()), counting(valueOf(args.remove()), () -> new PokemonDto(valueOf(args.remove()), valueOf(args.remove()), valueOf(args.remove()), valueOf(args.remove()), valueOf(args.remove()), valueOf(args.remove()))));
    }

    private static List<PokemonDto> counting(int counter, Supplier<PokemonDto> supplier) {
        List<PokemonDto> pokemons = new ArrayList<>();
        while (counter-- > 0) {
            pokemons.add(supplier.get());
        }
        return pokemons;
    }
}
