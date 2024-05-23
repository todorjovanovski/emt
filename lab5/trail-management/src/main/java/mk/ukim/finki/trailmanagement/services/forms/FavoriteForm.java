package mk.ukim.finki.trailmanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.trailmanagement.domain.models.favorite.Favorite;

import javax.validation.constraints.NotNull;

@Data
public class FavoriteForm {
    @NotNull
    private Favorite favorite;
}
