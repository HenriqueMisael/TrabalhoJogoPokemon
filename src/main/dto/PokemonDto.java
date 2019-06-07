package main.dto;

public class PokemonDto {

    public final int especie;
    public final int nivel;
    public final int ataqueUm;
    public final int ataqueDois;
    public final int ataqueTres;
    public final int ataqueQuatro;

    public PokemonDto(int especie, int nivel, int ataqueUm, int ataqueDois, int ataqueTres, int ataqueQuatro) {
        this.especie = especie;
        this.nivel = nivel;
        this.ataqueUm = ataqueUm;
        this.ataqueDois = ataqueDois;
        this.ataqueTres = ataqueTres;
        this.ataqueQuatro = ataqueQuatro;
    }
}
