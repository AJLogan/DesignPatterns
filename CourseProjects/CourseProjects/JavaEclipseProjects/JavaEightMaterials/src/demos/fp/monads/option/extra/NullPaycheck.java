package demos.fp.monads.option.extra;

public class NullPaycheck extends Paycheck {
    public NullPaycheck() {
        super(0.0);
    }

    @Override
    public double calcBonus() {
        return 0.0;
    }

    @Override
    public double basicWage() {
        return 0.0;
    }

    @Override
    public boolean eligibleForPerformanceBonus() {
        return false;
    }

}
