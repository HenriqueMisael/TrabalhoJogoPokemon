package pokemon;

import ataques.AttackDamage;
import ataques.AttackHit;
import util.Probabilidade;

public enum Status {

    OK{
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
    }, FAINTED{
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
    }, BURN{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            afetado.reduzHp(afetado.getHpMax()*6.25);
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            dano.attack /= 2;
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            //N�o tem efeito no c�lculo de acerto
        }   
    }, FROZEN{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            if(Probabilidade.calcula(10))
                afetado.setStatus(Status.OK);
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //N�o tem efeito no c�lculo de dano
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            acerto.attackAccuracy -= 1;
        }   
    }, PARALYSIS{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            //N�o tem efeito p�s-turno
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //N�o tem efeito no c�lculo de dano
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            acerto.attackAccuracy -= 0.25;
        }   
    }, POISON{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            afetado.reduzHp(afetado.getHpMax()*6.25);
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //N�o tem efeito no c�lculo de dano
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            //N�o tem efeito no c�lculo de acerto
        }    
    }, SLEEP {
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            if(Probabilidade.calcula(20))
                afetado.setStatus(Status.OK);
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //N�o tem efeito no c�lculo de dano
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            acerto.attackAccuracy -= 1;
        }   
    };
    
    public abstract void aplicaEfeitoPosTurno(Pokemon afetado);
    public abstract void aplicaEfeitoDano(AttackDamage dano);
    public abstract void aplicaEfeitoAcerto(AttackHit acerto);
}
