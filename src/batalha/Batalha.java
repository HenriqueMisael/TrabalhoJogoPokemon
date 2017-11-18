package batalha;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Batalha {

	//ATRIBUTOS
    Jogador time1, time2;
    private String[][] tabelaPokemons = new String[151][9];
    private String[][] tabelaAtaques = new String[165][8];
    
    //CONSTRUTOR
    public Batalha(Jogador p1, Jogador p2) {
        time1 = p1;
        time2 = p2;        
    }
    
    //METODOS
    public void carregarTableas(){
        System.out.println("Lendo tabela de Especies...");
        carregarTablaEspecies();
        System.out.println("\nLendo tabela de Ataques...");
        carregarTabelaAtaques();
    }
    
    public void carregarTablaEspecies(){
        String caminhoPokemons = "Tabela_Especies.txt";     
        BufferedReader conteudo;
        String linha;
        String separadorCampo = "\t"; //separar a cada tab
        
        int i=0, j=0;
        
        //Ler tabela de especies (pokemons)
        try{
            conteudo = new BufferedReader(new FileReader(caminhoPokemons));
            
            while (i<151){
            	j = 0;
                linha = conteudo.readLine();
                String[] camposLidos = linha.split(separadorCampo);
                for(String s: camposLidos){
                    System.out.println("["+i+"]["+j+"] = "+s); //print de teste (pode ser pagado)
                    tabelaPokemons[i][j] = s;
                    j++;
                }
                i++;
            }
        }catch(IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
            
        }finally{
            
        }
        
    }
    
    public void carregarTabelaAtaques(){
        String caminhoAtaques = "Tabela_Ataques.txt";        
        BufferedReader conteudo;
        String linha;
        String separadorCampo = "\t"; //separar a cada tab
        
        int i=0, j=0;
        
        //Ler tabela de especies (pokemons)
        try{
            conteudo = new BufferedReader(new FileReader(caminhoAtaques));
            while (i<151){
            	j = 0;
                linha = conteudo.readLine();
                String[] camposLidos = linha.split(separadorCampo);
                for(String s: camposLidos){
                    System.out.println("["+i+"]["+j+"] = "+s); //print de teste (pode ser pagado)
                    tabelaPokemons[i][j] = s;
                    j++;
                }
                i++;
            }
        }catch(IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
            
        }finally{
            
        }
        
    }
        
    public void start() {

        int vencedor = 0;
        Queue<Turno> turnos = new LinkedList<Turno>();
        
        while( vencedor == 0 ) {
            
            turnos.add(new Turno(time1.escolherComando(), time2.escolherComando()));
            
            /*
                Verifica vitória
            */
            if( !time1.temPokemonUtilizavel() )
                vencedor = 1;
            else if( !time2.temPokemonUtilizavel() )
                vencedor = 2;            
        }
        
    }

}
