package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import pokemon.Tipo;

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
	
	public Tipo getType(int id) {
		return pokemon.Tipo.valueOf(tabelaAtaques[id-1][2].toUpperCase());
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
	
	public String[] getParametros(int id) {
		
	    StringTokenizer st;
	    String[] parametros;
	    int i = 0;
	    
	    if(tabelaAtaques[id-1][7] == null)
	    	return null;
	    
	    st = new StringTokenizer(tabelaAtaques[id-1][7], ", ");
	    parametros = new String[st.countTokens()];
	    
	    while(st.hasMoreTokens()) {
	        parametros[i++] = st.nextToken();
	    }
	    
	    return parametros;
	}
}
