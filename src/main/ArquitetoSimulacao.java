package main;

import java.util.Queue;

import ataques.*;
import batalha.Jogador;
import batalha.JogadorHumano;
import batalha.JogadorMaquina;
import pokemon.Especie;
import pokemon.Pokemon;
import pokemon.Status;

public class ArquitetoSimulacao {

    static TabelaDeEspecies tabelaEspecies = new TabelaDeEspecies("Tabela_Especies.txt");
    static TabelaDeAtaques tabelaAtaques = new TabelaDeAtaques("Tabela_Ataques.txt");   
    private static int criaId = 1;
    
    public static Jogador retornaJogadorConformeTipo(int tipoJogador) {
        
        Jogador p = null;
        
        switch( tipoJogador ) {
            case 0: p = new JogadorMaquina(criaId++);break;
            case 1: p = new JogadorHumano(criaId++);break;
        }

        return p;
    }

    public static void montaTimePokemon(Jogador p, Queue<Integer> argumentos, int quantidadePokemons) {        

        for( int i = 0; i < quantidadePokemons; i++ ) {
            p.adicionarPokemon(new Pokemon(/* especie */ arquitetaEspecie(argumentos.remove()),
                                           /* level   */ argumentos.remove(),
                                           /* ataque1 */ arquitetaAtaque(argumentos.remove()),
                                           /* ataque2 */ arquitetaAtaque(argumentos.remove()),
                                           /* ataque3 */ arquitetaAtaque(argumentos.remove()),
                                           /* ataque4 */ arquitetaAtaque(argumentos.remove()))
                              );
        }
    }
    
    private static Especie arquitetaEspecie(int id) {
        return new Especie( id, tabelaEspecies.getEspecie(id),
                                tabelaEspecies.getTipo1(id), 
                                tabelaEspecies.getTipo2(id), 
                                tabelaEspecies.getBaseHP(id), 
                                tabelaEspecies.getBaseATK(id),  
                                tabelaEspecies.getBaseDEF(id),  
                                tabelaEspecies.getBaseSPE(id), 
                                tabelaEspecies.getBaseSPD(id));
    }
    
    private static Ataque arquitetaAtaque(int id) {
        
        Ataque ataque;
        String[] modificadores;
        String tipo;
        
        if(id == 0)
        	return null;
        
        modificadores = tabelaAtaques.getParametros(id);
        tipo = tabelaAtaques.getClasse(id);
                
        if(tipo.equals("charge")) {
            ataque = new AtaqueCharge(id, tabelaAtaques.getNome(id),
                                          tabelaAtaques.getPP(id),
                                          tabelaAtaques.getPower(id),
                                          tabelaAtaques.getAccuracy(id),
                                          tabelaAtaques.getType(id));
        }else if(tipo.equals("fixo")) {
            ataque = new AtaqueFixo(id, tabelaAtaques.getNome(id),
                                        tabelaAtaques.getPP(id),
                                        tabelaAtaques.getPower(id),
                                        tabelaAtaques.getAccuracy(id),
                                        tabelaAtaques.getType(id),
                                        Integer.parseInt(modificadores[0]));
        }else if(tipo.equals("hp")) {
            ataque = new AtaqueHp(id, tabelaAtaques.getNome(id),
                                      tabelaAtaques.getPP(id),
                                      tabelaAtaques.getPower(id),
                                      tabelaAtaques.getAccuracy(id),
                                      tabelaAtaques.getType(id),
                                      modificadores[0],
                                      Double.parseDouble(modificadores[1]));
        }else if(tipo.equals("modifier")) {
            ataque = new AtaqueModifier(id, tabelaAtaques.getNome(id),
                                            tabelaAtaques.getPP(id),
                                            tabelaAtaques.getPower(id),
                                            tabelaAtaques.getAccuracy(id),
                                            tabelaAtaques.getType(id),
                                            modificadores[0],
                                            Integer.parseInt(modificadores[1]),
                                            Integer.parseInt(modificadores[2]));
        }else if(tipo.equals("multihit")) {
            ataque = new AtaqueMultiHit(id, tabelaAtaques.getNome(id),            
                                            tabelaAtaques.getPP(id),              
                                            tabelaAtaques.getPower(id),           
                                            tabelaAtaques.getAccuracy(id),        
                                            tabelaAtaques.getType(id),            
                                            Integer.parseInt(modificadores[0]),   
                                            Integer.parseInt(modificadores[1]));
        }else if(tipo.equals("status")) {
            ataque = new AtaqueStatus(id, tabelaAtaques.getNome(id),          
                                          tabelaAtaques.getPP(id),            
                                          tabelaAtaques.getPower(id),         
                                          tabelaAtaques.getAccuracy(id),      
                                          tabelaAtaques.getType(id),          
                                          Status.valueOf(modificadores[0].toUpperCase()), 
                                          Integer.parseInt(modificadores[1]));
        }else {
            ataque = new Ataque(id, tabelaAtaques.getNome(id),          
                                    tabelaAtaques.getPP(id),            
                                    tabelaAtaques.getPower(id),         
                                    tabelaAtaques.getAccuracy(id),      
                                    tabelaAtaques.getType(id));            
        }
        
        return ataque;
    }
}
