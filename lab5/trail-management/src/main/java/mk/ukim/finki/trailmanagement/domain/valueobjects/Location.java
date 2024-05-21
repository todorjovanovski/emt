package mk.ukim.finki.trailmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

import java.util.Objects;

@Embeddable
@Getter
public class Location implements ValueObject {
    private final String country;
    private final String city;
    private final double latitude;
    private final double longitude;

    protected Location() {
        country = "";
        city = "";
        latitude = 0.0;
        longitude = 0.0;
    }

    public Location(@NonNull String country, @NonNull String city, @NonNull Double latitude, @NonNull Double longitude) {
        if (!isValidLatitude(latitude) || !isValidLongitude(longitude)) {
            throw new IllegalArgumentException("Invalid latitude or longitude values");
        }
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private boolean isValidLatitude(double latitude) {
        return latitude >= -90.0 && latitude <= 90.0;
    }

    private boolean isValidLongitude(double longitude) {
        return longitude >= -180.0 && longitude <= 180.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.latitude, latitude) == 0 &&
                Double.compare(location.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
