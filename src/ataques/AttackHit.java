package ataques;

public class AttackHit {

    public double attackAccuracy;
    public double accuracy;
    public double evasion;

    public boolean calculate() {
        return util.Probabilidade.calcula(this.attackAccuracy*(this.accuracy/this.evasion));
    }
}
