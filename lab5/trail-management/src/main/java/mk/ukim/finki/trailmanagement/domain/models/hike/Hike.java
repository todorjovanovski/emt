package mk.ukim.finki.trailmanagement.domain.models.hike;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.trailmanagement.domain.models.trail.TrailId;
import mk.ukim.finki.trailmanagement.domain.valueobjects.UserId;

import java.time.LocalDateTime;

@Entity
@Table(name = "hikes")
@Getter
public class Hike extends AbstractEntity<HikeId> {
    private UserId userId;
    private TrailId trailId;
    private LocalDateTime date;

}
