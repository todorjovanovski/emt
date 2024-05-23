package mk.ukim.finki.trailmanagement.domain.models.exceptions;

public class FavoriteIdNonExistentException extends RuntimeException{
    public FavoriteIdNonExistentException() {
        super("Favorite does not exist!");
    }
}
