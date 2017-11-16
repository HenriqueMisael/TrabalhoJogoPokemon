package main;

import java.util.LinkedList;
import java.util.Queue;

import batalha.Batalha;
import batalha.Jogador;
import batalha.JogadorHumano;
import batalha.JogadorMaquina;
import batalha.Pokemon;

public class TrabalhoJavaPokemon {

	public static void main(String[] args) {
		
		Queue<Integer> argumentos = new LinkedList<Integer>();
		Batalha batalha;
		Jogador p1, p2;
		
		for( String a:args ) {
			argumentos.add(Integer.parseInt(a));
		}
		
		p1 = retornaJogadorConformeTipo( argumentos.remove() );
		montaTimePokemon(p1, argumentos, argumentos.remove());
		
		p2 = retornaJogadorConformeTipo( argumentos.remove() );
		montaTimePokemon(p2, argumentos, argumentos.remove());
		
		batalha = new Batalha( p1, p2 );
		batalha.start();
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
		System.out.println("\nRestante: " + argumentos.toString());
		for( int i = 0; i < quantidadePokemons; i++ ) {
			p.adicionarPokemon(new Pokemon(argumentos.remove(),argumentos.remove(),argumentos.remove(),argumentos.remove(),argumentos.remove(),argumentos.remove()));
		}
	}
}
