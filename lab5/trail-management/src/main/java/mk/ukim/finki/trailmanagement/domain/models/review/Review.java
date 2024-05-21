package mk.ukim.finki.trailmanagement.domain.models.review;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.trailmanagement.domain.models.trail.TrailId;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Rating;
import mk.ukim.finki.trailmanagement.domain.valueobjects.UserId;

@Entity
@Table(name = "reviews")
@Getter
public class Review extends AbstractEntity<ReviewId> {
    private UserId userId;
    private TrailId trailId;
    private String comment;
    private Rating rating;
}
