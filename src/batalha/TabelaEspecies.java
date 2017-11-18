package batalha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabelaEspecies {
	private String[][] tabelaPokemons = new String[151][9];
	
	//CONSTRUTOR (Cria a matriz a partir do arquivo)
	public TabelaEspecies() {
		carregarTablaEspecies();
	}
	
	//METODOS
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
	
	public String getEspecie(int id) {
		return tabelaPokemons[id-1][1];
	}
}
