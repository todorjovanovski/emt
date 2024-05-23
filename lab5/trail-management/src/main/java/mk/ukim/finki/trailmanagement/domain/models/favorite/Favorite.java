package mk.ukim.finki.trailmanagement.domain.models.favorite;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.trailmanagement.domain.models.trail.TrailId;
import mk.ukim.finki.trailmanagement.domain.valueobjects.UserId;

@Entity
@Table(name = "favorites")
@Getter
public class Favorite extends AbstractEntity<FavoriteId> {
    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    private UserId userId;
    @AttributeOverride(name = "id", column = @Column(name = "trail_id"))
    private TrailId trailId;
}
