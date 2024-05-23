package mk.ukim.finki.trailmanagement.domain.models.trail;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.trailmanagement.domain.models.favorite.Favorite;
import mk.ukim.finki.trailmanagement.domain.models.favorite.FavoriteId;
import mk.ukim.finki.trailmanagement.domain.models.hike.Hike;
import mk.ukim.finki.trailmanagement.domain.models.hike.HikeId;
import mk.ukim.finki.trailmanagement.domain.models.review.Review;
import mk.ukim.finki.trailmanagement.domain.models.review.ReviewId;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Distance;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Location;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Rating;

import java.util.Set;

@Entity
@Table(name = "trails")
@Getter
public class Trail extends AbstractEntity<TrailId> {

    private String name;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    private Location location;
    private Distance distance;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Hike> trailHikes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Review> trailReviews;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Favorite> trailFavorites;

    public Hike addHike(@NonNull Hike hike) {
        trailHikes.add(hike);
        return hike;
    }

    //OVERRIDE EQUALS
    public void removeHike(@NonNull HikeId id) {
        trailHikes.removeIf(h -> h.getId().equals(id));
    }

    public Review addReview(@NonNull Review review) {
        trailReviews.add(review);
        return review;
    }

    //OVERRIDE EQUALS
    public void removeReview(@NonNull ReviewId id) {
        trailReviews.removeIf(r -> r.getId().equals(id));
    }

    public Favorite addToFavorites(@NonNull Favorite favorite) {
        trailFavorites.add(favorite);
        return favorite;
    }

    //OVERRIDE EQUALS
    public void removeFromFavorites(@NonNull FavoriteId id) {
        trailFavorites.removeIf(f -> f.getId().equals(id));
    }

    public Rating rating() {
        double avg = trailReviews.stream()
                .map(Review::getRating)
                .map(Rating::getScore)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
        return new Rating(avg);
    }

}
