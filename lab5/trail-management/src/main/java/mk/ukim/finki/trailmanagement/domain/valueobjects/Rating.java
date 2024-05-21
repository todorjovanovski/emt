package mk.ukim.finki.trailmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

import java.util.Objects;

@Embeddable
@Getter
public class Rating implements ValueObject {
    private final int value;

    protected Rating() {
        value = 0;
    }

    public Rating(@NonNull Integer value) {
        if (!isValueValid(value)) {
            throw new IllegalArgumentException("Rating value must be between 0 and 5");
        }
        this.value = value;
    }

    private boolean isValueValid(int value) {
        return value > 0 && value <= 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return value == rating.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "value=" + value +
                '}';
    }
}
