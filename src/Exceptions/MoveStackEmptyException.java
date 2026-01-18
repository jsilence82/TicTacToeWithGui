package Exceptions;

public class MoveStackEmptyException extends RuntimeException {
    public MoveStackEmptyException() {
        super("No moves to undo");
    }

    public MoveStackEmptyException(String message) {
        super(message);
    }

    public MoveStackEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MoveStackEmptyException(Throwable cause) {
        super(cause);
    }

}
