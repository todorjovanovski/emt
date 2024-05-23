package mk.ukim.finki.trailmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Distance implements ValueObject {
    private final double length;
    private final DistanceUnit unit;

    public Distance() {
        length = 0.0;
        unit = DistanceUnit.KILOMETERS;
    }

    public Distance(@NonNull Double length, @NonNull DistanceUnit unit) {
        if (!isValueValid(length)) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }
        this.length = length;
        this.unit = unit;
    }

    private boolean isValueValid(double value) {
        return value > 0;
    }

    public Distance toUnit(DistanceUnit targetUnit) {
        if (unit == targetUnit) {
            return this;
        }
        double convertedValue = length * unit.toBaseUnitFactor() / targetUnit.toBaseUnitFactor();
        return new Distance(convertedValue, targetUnit);
    }

    public Distance add(Distance other) {
        Distance convertedOther = other.toUnit(this.unit);
        return new Distance(this.length + convertedOther.length, this.unit);
    }

    public Distance subtract(Distance other) {
        Distance convertedOther = other.toUnit(this.unit);
        return new Distance(this.length - convertedOther.length, this.unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return Double.compare(distance.toUnit(this.unit).length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(length * unit.toBaseUnitFactor());
    }

    @Override
    public String toString() {
        return length + " " + unit;
    }
}
