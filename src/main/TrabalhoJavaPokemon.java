package main;

import java.util.LinkedList;
import java.util.Queue;

import batalha.Batalha;
import batalha.Jogador;
import batalha.JogadorHumano;
import batalha.JogadorMaquina;
import pokemon.Especie;
import pokemon.Pokemon;

public class TrabalhoJavaPokemon {

    static TabelaDeEspecies tabelaEspecies = new TabelaDeEspecies("Tabela_Especies.txt");
    static TabelaDeAtaques tabelaAtaques = new TabelaDeAtaques("Tabela_Ataques.txt");      
    
    public static void main(String[] args) {
    	
        Queue<Integer> argumentos = new LinkedList<Integer>();
        Batalha batalha;
        Jogador p1, p2;
        
        System.out.print("Entrada: ");
        for( String a:args ) {
            System.out.print(a);
            argumentos.add(Integer.parseInt(a));
        }
       
        p1 = retornaJogadorConformeTipo( argumentos.remove() );
        montaTimePokemon(p1, argumentos, argumentos.remove());
        
        p2 = retornaJogadorConformeTipo( argumentos.remove() );
        montaTimePokemon(p2, argumentos, argumentos.remove());
        
        batalha = new Batalha( p1, p2 );
        //batalha.start();
    }

    private static Jogador retornaJogadorConformeTipo(int tipoJogador) {
        
        Jogador p = null;
        
        switch( tipoJogador ) {
            case 0: p = new JogadorMaquina();break;
            case 1: p = new JogadorHumano();break;
        }

        return p;
    }

    private static void montaTimePokemon(Jogador p, Queue<Integer> argumentos, int quantidadePokemons) {        

        Especie especie;
        int especieId;
        
        for( int i = 0; i < quantidadePokemons; i++ ) {
        	especieId = argumentos.remove();            
            especie = new Especie( especieId, tabelaEspecies.getEspecie(especieId),
                                              tabelaEspecies.getTipo1(especieId),
                                              tabelaEspecies.getTipo2(especieId),
                                              tabelaEspecies.getBaseHP(especieId),
                                              tabelaEspecies.getBaseATK(especieId), 
                                              tabelaEspecies.getBaseDEF(especieId), 
                                              tabelaEspecies.getBaseSPE(especieId),
                                              tabelaEspecies.getBaseSPD(especieId));
            p.adicionarPokemon(new Pokemon(especie,argumentos.remove(),argumentos.remove(),argumentos.remove(),argumentos.remove(),argumentos.remove()));
        }
    }
}
