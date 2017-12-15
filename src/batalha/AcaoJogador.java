package batalha;

public interface AcaoJogador {
    /*
        Interface para as ações possíveis do jogador, a fim de generalizar o tratamento
            das ações quando assim for possível. Por definição, apenas a execução de uma
            ação a diferenciará das demais.
    */    
    public AcaoJogador executa();
    public String message();
    public boolean equals( Object obj );
    public int getPlayer();
}
