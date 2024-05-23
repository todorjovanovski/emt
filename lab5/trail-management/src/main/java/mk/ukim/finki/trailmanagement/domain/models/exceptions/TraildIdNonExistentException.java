package mk.ukim.finki.trailmanagement.domain.models.exceptions;

public class TraildIdNonExistentException extends RuntimeException{
    public TraildIdNonExistentException() {
        super("Trail does not exist!");
    }
}
