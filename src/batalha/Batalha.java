package batalha;

public class Batalha {

    Jogador time1, time2;
    
    public Batalha(Jogador p1, Jogador p2) {
        time1 = p1;
        time2 = p2;        
    }    
        
    public void start() {

        System.out.println(String.format("Jogador 1: %1s", time1.toString()));
        System.out.println(String.format("Jogador 2: %1s", time2.toString()));
        
    }

}
