package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import pokemon.Tipo;

public class TabelaDeEspecies {
    //ATRIBUTOS
	private String[][] tabelaPokemons = new String[151][9];
	
	//CONSTRUTOR (Cria a matriz a partir do arquivo)
	public TabelaDeEspecies(String caminho) {
		carregarTablaEspecies(caminho);
	}
	
	//METODOS
	public void carregarTablaEspecies(String caminho){    
        BufferedReader conteudo;
        String linha;
        String separadorCampo = "\t"; //separar a cada tab
        
        int i=0, j=0;
        
        //Ler tabela de especies (pokemons)
        try{
            conteudo = new BufferedReader(new FileReader(caminho));
            
            while (i<151){
            	j = 0;
                linha = conteudo.readLine();
                String[] camposLidos = linha.split(separadorCampo);
                for(String s: camposLidos){
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
	
	public String getEspecie(int id) {
		return tabelaPokemons[id-1][1];
	}
	
	public Tipo getTipo1(int id) {
		return Tipo.valueOf(tabelaPokemons[id-1][2].toUpperCase());
	}
	
	public Tipo getTipo2(int id) {
		
		String tipoString = tabelaPokemons[id-1][3].toUpperCase();
		
		if(tipoString.isEmpty())
			tipoString = "NONE";
		
		return Tipo.valueOf(tipoString);
	}
	
	public int getBaseHP(int id) {
		return Integer.parseInt(tabelaPokemons[id-1][4]);
	}
	
	public int getBaseATK(int id) {
		return Integer.parseInt(tabelaPokemons[id-1][5]);
	}
	
	public int getBaseDEF(int id) {
		return Integer.parseInt(tabelaPokemons[id-1][6]);
	}
	
	public int getBaseSPE(int id) {
		return Integer.parseInt(tabelaPokemons[id-1][7]);
	}
	
	public int getBaseSPD(int id) {
		return Integer.parseInt(tabelaPokemons[id-1][8]);
	}
}
