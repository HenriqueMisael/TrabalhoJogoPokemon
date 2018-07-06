package pokemon;

import ataques.AttackDamage;
import ataques.AttackHit;

public enum StatusSecundario implements Status {

    FLINCH{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            //Quando não existe status ativo, então não se faz nada
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //Quando não existe status ativo, então não se faz nada
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            //Quando não existe status ativo, então não se faz nada
        }        
    }, CONFUSION{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            //Quando o pokémon está morto, não se faz nada
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //Quando o pokémon está morto, não se faz nada
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            //Quando o pokémon está morto, não se faz nada
        }  
    }
}
