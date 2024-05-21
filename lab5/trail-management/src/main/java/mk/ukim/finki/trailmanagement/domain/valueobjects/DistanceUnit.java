package mk.ukim.finki.trailmanagement.domain.valueobjects;

public enum DistanceUnit {
    KILOMETERS(1.0),
    MILES(1.60934);

    private final double toBaseUnitFactor;

    DistanceUnit(double toBaseUnitFactor) {
        this.toBaseUnitFactor = toBaseUnitFactor;
    }

    public double toBaseUnitFactor() {
        return toBaseUnitFactor;
    }
}
