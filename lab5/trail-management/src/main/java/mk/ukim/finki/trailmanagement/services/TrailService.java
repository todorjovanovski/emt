package mk.ukim.finki.trailmanagement.services;

import mk.ukim.finki.trailmanagement.domain.models.exceptions.FavoriteIdNonExistentException;
import mk.ukim.finki.trailmanagement.domain.models.exceptions.HikeIdNonExistentException;
import mk.ukim.finki.trailmanagement.domain.models.exceptions.ReviewIdNonExistentException;
import mk.ukim.finki.trailmanagement.domain.models.exceptions.TraildIdNonExistentException;
import mk.ukim.finki.trailmanagement.domain.models.favorite.FavoriteId;
import mk.ukim.finki.trailmanagement.domain.models.hike.HikeId;
import mk.ukim.finki.trailmanagement.domain.models.review.ReviewId;
import mk.ukim.finki.trailmanagement.domain.models.trail.Trail;
import mk.ukim.finki.trailmanagement.domain.models.trail.TrailId;
import mk.ukim.finki.trailmanagement.services.forms.FavoriteForm;
import mk.ukim.finki.trailmanagement.services.forms.HikeForm;
import mk.ukim.finki.trailmanagement.services.forms.ReviewForm;

import java.util.List;
import java.util.Optional;

public interface TrailService {
    List<Trail> findAll();
    Optional<Trail> findById(TrailId id);

    void addHike(TrailId trailId, HikeForm hikeForm)
            throws TraildIdNonExistentException;
    void deleteHike(TrailId trailId, HikeId hikeId)
            throws TraildIdNonExistentException, HikeIdNonExistentException;

    void addReview(TrailId trailId, ReviewForm reviewForm)
            throws TraildIdNonExistentException;
    void deleteReview(TrailId trailId, ReviewId reviewId)
            throws TraildIdNonExistentException, ReviewIdNonExistentException;

    void addToFavorite(TrailId trailId, FavoriteForm favoriteForm)
            throws TraildIdNonExistentException;
    void deleteFromFavorites(TrailId trailId, FavoriteId favoriteId)
            throws TraildIdNonExistentException, FavoriteIdNonExistentException;
}
