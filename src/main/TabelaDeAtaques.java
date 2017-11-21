package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabelaDeAtaques {
	private String[][] tabelaAtaques = new String[165][8];
	
	public TabelaDeAtaques(String caminho){
		carregarTabelaAtaques(caminho);
	}
	
	public void carregarTabelaAtaques(String caminho){
        BufferedReader conteudo;
        String linha;
        String separadorCampo = "\t"; //separar a cada tab
        
        int i=0, j=0;
        
        //Ler tabela de especies (pokemons)
        try{
            conteudo = new BufferedReader(new FileReader(caminho));
            while (i<165){
            	j = 0;
                linha = conteudo.readLine();
                String[] camposLidos = linha.split(separadorCampo);
                for(String s: camposLidos){
                    tabelaAtaques[i][j] = s;
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
	
	public String getNome(int id) {
		return tabelaAtaques[id-1][1];
	}
	
	public String getType(int id) {
		return tabelaAtaques[id-1][2];
	}
	
	public int getPP(int id) {
		return Integer.parseInt(tabelaAtaques[id-1][3]);
	}
	
	public int getPower(int id) {
		return Integer.parseInt(tabelaAtaques[id-1][4]);
	}
	
	public int getAccuracy(int id) {
		return Integer.parseInt(tabelaAtaques[id-1][5]);
	}
	
	public String getClasse(int id) {
		return tabelaAtaques[id-1][6];
	}
	
	public String getParametros(int id) {
		return tabelaAtaques[id-1][7];
	}
}
