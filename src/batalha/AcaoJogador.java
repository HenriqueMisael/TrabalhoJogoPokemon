package batalha;

public interface AcaoJogador {
    /*
        Interface para as a��es poss�veis do jogador, a fim de generalizar o tratamento
            das a��es quando assim for poss�vel. Por defini��o, apenas a execu��o de uma
            a��o a diferenciar� das demais.
    */    
    public AcaoJogador executa();
    public String message();
    public boolean equals( Object obj );
    public int getPlayer();
}
