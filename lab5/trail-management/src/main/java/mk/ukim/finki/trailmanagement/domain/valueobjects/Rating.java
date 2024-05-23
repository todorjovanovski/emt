package mk.ukim.finki.trailmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

import java.util.Objects;

@Embeddable
@Getter
public class Rating implements ValueObject {
    private final double score;

    protected Rating() {
        score = 0.0;
    }

    public Rating(@NonNull Double score) {
        if (!isValueValid(score)) {
            throw new IllegalArgumentException("Rating value must be between 0 and 5");
        }
        this.score = score;
    }

    private boolean isValueValid(double value) {
        return value > 0.0 && value <= 5.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return score == rating.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "value=" + score +
                '}';
    }
}
