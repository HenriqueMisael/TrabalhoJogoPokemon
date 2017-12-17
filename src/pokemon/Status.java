package pokemon;

import ataques.AttackDamage;
import ataques.AttackHit;
import util.Probabilidade;

public enum Status {

    OK{
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
    }, FAINTED{
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
            //Não tem efeito no cálculo de acerto
        }   
    }, FROZEN{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            if(Probabilidade.calcula(10))
                afetado.setStatus(Status.OK);
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //Não tem efeito no cálculo de dano
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            acerto.attackAccuracy -= 1;
        }   
    }, PARALYSIS{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            //Não tem efeito pós-turno
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //Não tem efeito no cálculo de dano
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
            //Não tem efeito no cálculo de dano
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            //Não tem efeito no cálculo de acerto
        }    
    }, SLEEP {
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            if(Probabilidade.calcula(20))
                afetado.setStatus(Status.OK);
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //Não tem efeito no cálculo de dano
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
