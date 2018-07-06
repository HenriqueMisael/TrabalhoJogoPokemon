package pokemon;

import java.util.ArrayList;

import ataques.AttackDamage;
import ataques.AttackHit;

public class StatusController {

    private ArrayList<StatusSecundario> statusSecundarios = new ArrayList<StatusSecundario>();
    private StatusPrimario statusPrimario = StatusPrimario.OK;
    
    void setStatusPrimario(StatusPrimario status) {
        this.statusPrimario = status;
    }
    
    void freeStatusPrimario() {
        statusPrimario = StatusPrimario.OK;
    }
    
    void addStatusSecundario(StatusSecundario status) {
        if(!statusSecundarios.contains(status))
            statusSecundarios.add(status);
    }
    
    void freeStatusSecundario(Status status) {
        statusSecundarios.remove(status);
    }
    
    public void aplicaEfeitoPosTurno(Pokemon afetado) {
        for(Status s:statusSecundarios)
            s.aplicaEfeitoPosTurno(afetado);
        statusPrimario.aplicaEfeitoPosTurno(afetado);
    };
    
    public void aplicaEfeitoDano(AttackDamage dano) {
        for(Status s:statusSecundarios)
            s.aplicaEfeitoDano(dano);
        statusPrimario.aplicaEfeitoDano(dano);
    };
    
    public void aplicaEfeitoAcerto(AttackHit acerto) {
        for(Status s:statusSecundarios)
            s.aplicaEfeitoAcerto(acerto);
        statusPrimario.aplicaEfeitoAcerto(acerto);
    }

    public boolean contains(Status status) {
        return status.equals(statusPrimario) || statusSecundarios.contains(status);
    };
}
