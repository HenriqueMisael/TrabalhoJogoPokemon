package pokemon;

import ataques.AttackDamage;
import ataques.AttackHit;

public interface Status {
    
    void aplicaEfeitoPosTurno(Pokemon afetado);
    void aplicaEfeitoDano(AttackDamage dano);
    void aplicaEfeitoAcerto(AttackHit acerto);
    
}
