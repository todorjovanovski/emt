package mk.ukim.finki.trailmanagement.domain.models.trail;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Distance;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Location;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Rating;

@Entity
@Table(name = "trails")
@Getter
public class Trail extends AbstractEntity<TrailId> {

    private String name;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private Location location;
    private Distance distance;
    private Rating rating;
}
