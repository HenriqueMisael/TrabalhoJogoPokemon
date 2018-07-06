package pokemon;

import ataques.AttackDamage;
import ataques.AttackHit;

public interface Status {
    
    public abstract void aplicaEfeitoPosTurno(Pokemon afetado);
    public abstract void aplicaEfeitoDano(AttackDamage dano);
    public abstract void aplicaEfeitoAcerto(AttackHit acerto);
    
}
