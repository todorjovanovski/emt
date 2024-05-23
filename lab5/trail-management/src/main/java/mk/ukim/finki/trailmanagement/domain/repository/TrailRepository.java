package mk.ukim.finki.trailmanagement.domain.repository;

import mk.ukim.finki.trailmanagement.domain.models.trail.Trail;
import mk.ukim.finki.trailmanagement.domain.models.trail.TrailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailRepository extends JpaRepository<Trail, TrailId> {
}
