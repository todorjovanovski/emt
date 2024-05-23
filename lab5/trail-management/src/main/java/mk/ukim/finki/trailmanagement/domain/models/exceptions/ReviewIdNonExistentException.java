package mk.ukim.finki.trailmanagement.domain.models.exceptions;

public class ReviewIdNonExistentException extends RuntimeException{
    public ReviewIdNonExistentException() {
        super("Review doest not exist!");
    }
}
