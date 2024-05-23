package mk.ukim.finki.trailmanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.trailmanagement.domain.models.trail.Difficulty;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Distance;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Location;
import mk.ukim.finki.trailmanagement.domain.valueobjects.Rating;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class TrailForm {

    @NotNull
    private String name;
    @NotNull
    private Difficulty difficulty;
    @NotNull
    private Location location;
    @NotNull
    private Distance distance;
    @NotNull
    private Rating rating;

    @Valid
    @NotEmpty
    private List<HikeForm> hikes = new ArrayList<>();

    @Valid
    @NotEmpty
    private List<ReviewForm> reviews = new ArrayList<>();

    @Valid
    @NotEmpty
    private List<FavoriteForm> favorites = new ArrayList<>();
}
