package mk.ukim.finki.trailmanagement.services.impl;

import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.trailmanagement.domain.models.exceptions.FavoriteIdNonExistentException;
import mk.ukim.finki.trailmanagement.domain.models.exceptions.HikeIdNonExistentException;
import mk.ukim.finki.trailmanagement.domain.models.exceptions.ReviewIdNonExistentException;
import mk.ukim.finki.trailmanagement.domain.models.exceptions.TraildIdNonExistentException;
import mk.ukim.finki.trailmanagement.domain.models.favorite.FavoriteId;
import mk.ukim.finki.trailmanagement.domain.models.hike.HikeId;
import mk.ukim.finki.trailmanagement.domain.models.review.ReviewId;
import mk.ukim.finki.trailmanagement.domain.models.trail.Trail;
import mk.ukim.finki.trailmanagement.domain.models.trail.TrailId;
import mk.ukim.finki.trailmanagement.domain.repository.TrailRepository;
import mk.ukim.finki.trailmanagement.services.TrailService;
import mk.ukim.finki.trailmanagement.services.forms.FavoriteForm;
import mk.ukim.finki.trailmanagement.services.forms.HikeForm;
import mk.ukim.finki.trailmanagement.services.forms.ReviewForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TrailServiceImpl implements TrailService {

    private final TrailRepository trailRepository;

    private final Validator validator;

    @Override
    public List<Trail> findAll() {
        return trailRepository.findAll();
    }

    @Override
    public Optional<Trail> findById(TrailId id) {
        return trailRepository.findById(id);
    }

    @Override
    public void addHike(TrailId trailId, HikeForm hikeForm) throws TraildIdNonExistentException {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(TraildIdNonExistentException::new);
        trail.addHike(hikeForm.getHike());
        trailRepository.saveAndFlush(trail);
    }

    @Override
    public void deleteHike(TrailId trailId, HikeId hikeId) throws TraildIdNonExistentException, HikeIdNonExistentException {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(TraildIdNonExistentException::new);
        trail.removeHike(hikeId);
        trailRepository.saveAndFlush(trail);
    }

    @Override
    public void addReview(TrailId trailId, ReviewForm reviewForm) throws TraildIdNonExistentException {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(TraildIdNonExistentException::new);
        trail.addReview(reviewForm.getReview());
        trailRepository.saveAndFlush(trail);
    }

    @Override
    public void deleteReview(TrailId trailId, ReviewId reviewId) throws TraildIdNonExistentException, ReviewIdNonExistentException {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(TraildIdNonExistentException::new);
        trail.removeReview(reviewId);
        trailRepository.saveAndFlush(trail);
    }

    @Override
    public void addToFavorite(TrailId trailId, FavoriteForm favoriteForm) throws TraildIdNonExistentException {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(TraildIdNonExistentException::new);
        trail.addToFavorites(favoriteForm.getFavorite());
        trailRepository.saveAndFlush(trail);
    }

    @Override
    public void deleteFromFavorites(TrailId trailId, FavoriteId favoriteId) throws TraildIdNonExistentException, FavoriteIdNonExistentException {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(TraildIdNonExistentException::new);
        trail.removeFromFavorites(favoriteId);
        trailRepository.saveAndFlush(trail);
    }
}
