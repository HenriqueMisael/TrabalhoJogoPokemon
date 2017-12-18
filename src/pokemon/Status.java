package pokemon;

import ataques.AttackDamage;
import ataques.AttackHit;
import util.DefaultOutput;
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
            double dano = afetado.getHpMax()*0.0625;
            DefaultOutput.message(String.format("%s sofreu %.2f de dano por está sujeito a BURN.", afetado, dano));
            afetado.reduzHp(dano);
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            DefaultOutput.message("O ataque foi reduzido pela metade devido ao pokémon estar sob efeito de BURN.");
            dano.attack /= 2;
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            //Não tem efeito no cálculo de acerto
        }   
    }, FROZEN{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            DefaultOutput.message(String.format("%s tenta se livrar de FROZEN...", afetado));
            if(Probabilidade.calcula(10)) {
                DefaultOutput.message("e consegue.");
                afetado.setStatus(Status.OK);
            }else DefaultOutput.message("e falha.");
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //Não tem efeito no cálculo de dano
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            DefaultOutput.message("A chance de acerto desceu em 100% por causa do estado FROZEN.");
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
            DefaultOutput.message("A chance de acerto desceu em 25% por causa do estado PARALYSIS.");
            acerto.attackAccuracy -= 0.25;
        }   
    }, POISON{
        @Override
        public void aplicaEfeitoPosTurno(Pokemon afetado) {
            double dano = afetado.getHpMax()*0.0625;
            DefaultOutput.message(String.format("%s sofreu %.2f de dano por está sujeito a POISON.", afetado, dano));
            afetado.reduzHp(dano);
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
            DefaultOutput.message(String.format("%s tenta se livrar de SLEEP...", afetado));
            if(Probabilidade.calcula(20)) {
                DefaultOutput.message("e consegue.");
                afetado.setStatus(Status.OK);
            }else DefaultOutput.message("e falha.");
        }
        @Override
        public void aplicaEfeitoDano(AttackDamage dano) {
            //Não tem efeito no cálculo de dano
        }
        @Override
        public void aplicaEfeitoAcerto(AttackHit acerto) {
            DefaultOutput.message("A chance de acerto desceu em 100% por causa do estado SLEEP.");
            acerto.attackAccuracy -= 1;
        }   
    };
    
    public abstract void aplicaEfeitoPosTurno(Pokemon afetado);
    public abstract void aplicaEfeitoDano(AttackDamage dano);
    public abstract void aplicaEfeitoAcerto(AttackHit acerto);
}
