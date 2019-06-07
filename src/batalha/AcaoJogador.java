package batalha;

public interface AcaoJogador {

    AcaoJogador executa();

    String message();

    boolean equals(Object obj);

    int getPlayer();

    double getPriority();
}
