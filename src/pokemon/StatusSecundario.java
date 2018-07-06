package pokemon;

import ataques.AttackDamage;
import ataques.AttackHit;

public enum StatusSecundario implements Status {

    FLINCH{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            //Quando n�o existe status ativo, ent�o n�o se faz nada
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //Quando n�o existe status ativo, ent�o n�o se faz nada
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            //Quando n�o existe status ativo, ent�o n�o se faz nada
        }        
    }, CONFUSION{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            //Quando o pok�mon est� morto, n�o se faz nada
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //Quando o pok�mon est� morto, n�o se faz nada
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            //Quando o pok�mon est� morto, n�o se faz nada
        }  
    }
}
