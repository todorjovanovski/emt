package mk.ukim.finki.trailmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Embeddable
@Getter
public class Duration implements ValueObject {
    private final long duration;
    private final TimeUnit unit;

    protected Duration() {
        duration = 0L;
        unit = TimeUnit.SECONDS;
    }

    public Duration(@NonNull Long duration, @NonNull TimeUnit unit) {
        if (!isDurationValid(duration)) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        this.duration = duration;
        this.unit = unit;
    }

    private boolean isDurationValid(long duration) {
        return duration > 0;
    }

    public Duration convertTo(TimeUnit targetUnit) {
        long targetDuration = targetUnit.convert(duration, unit);
        return new Duration(targetDuration, targetUnit);
    }

    public Duration add(Duration other) {
        long thisDurationInTargetUnit = unit.convert(other.duration, other.unit);
        long resultDuration = duration + thisDurationInTargetUnit;
        return new Duration(resultDuration, unit);
    }

    public Duration subtract(Duration other) {
        long thisDurationInTargetUnit = unit.convert(other.duration, other.unit);
        long resultDuration = duration - thisDurationInTargetUnit;
        if (!isDurationValid(resultDuration)) {
            throw new IllegalArgumentException("Resulting duration cannot be negative");
        }
        return new Duration(resultDuration, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration1 = (Duration) o;
        return duration == duration1.duration && unit == duration1.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, unit);
    }

    @Override
    public String toString() {
        return "Duration{" +
                "duration=" + duration +
                ", unit=" + unit +
                '}';
    }
}
