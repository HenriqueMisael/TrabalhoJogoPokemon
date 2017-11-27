package main;

import java.util.LinkedList;
import java.util.Queue;

import batalha.Batalha;
import batalha.Jogador;

public class TrabalhoJavaPokemon {

    public static void main(String[] args) {
    	
        Queue<Integer> argumentos = new LinkedList<Integer>();
        Batalha batalha;
        Jogador p1, p2;
        
        System.out.print("Entrada: ");
        for( String a:args ) {
            System.out.print(a);
            argumentos.add(Integer.parseInt(a));
        }
       
        p1 = ArquitetoSimulacao.retornaJogadorConformeTipo( argumentos.remove() );
        ArquitetoSimulacao.montaTimePokemon(p1, argumentos, argumentos.remove());
        
        p2 = ArquitetoSimulacao.retornaJogadorConformeTipo( argumentos.remove() );
        ArquitetoSimulacao.montaTimePokemon(p2, argumentos, argumentos.remove());
        
        batalha = new Batalha( p1, p2 );
        //batalha.start();
    }
}
