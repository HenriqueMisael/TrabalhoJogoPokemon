package pokemon;

import ataques.AttackDamage;
import ataques.AttackHit;

import java.util.ArrayList;

public class StatusController {

    private final ArrayList<StatusSecundario> statusSecundarios = new ArrayList<>();
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
    
    public void aplicaEfeitoPosTurno(Pokemon afetado) {
        for(Status s:statusSecundarios)
            s.aplicaEfeitoPosTurno(afetado);
        statusPrimario.aplicaEfeitoPosTurno(afetado);
    }

    public void aplicaEfeitoDano(AttackDamage dano) {
        for(Status s:statusSecundarios)
            s.aplicaEfeitoDano(dano);
        statusPrimario.aplicaEfeitoDano(dano);
    }

    public void aplicaEfeitoAcerto(AttackHit acerto) {
        for(Status s:statusSecundarios)
            s.aplicaEfeitoAcerto(acerto);
        statusPrimario.aplicaEfeitoAcerto(acerto);
    }

    public boolean contains(Status status) {
        return status.equals(statusPrimario) || statusSecundarios.contains(status);
    }
}
