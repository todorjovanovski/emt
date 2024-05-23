package mk.ukim.finki.trailmanagement.domain.models.exceptions;

public class HikeIdNonExistentException extends RuntimeException{
    public HikeIdNonExistentException() {
        super("Hike does not exist!");
    }
}
