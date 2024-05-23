package mk.ukim.finki.trailmanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.trailmanagement.domain.models.hike.Hike;

import javax.validation.constraints.NotNull;

@Data
public class HikeForm {
    @NotNull
    private Hike hike;
}
