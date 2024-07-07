package continental.java.rest;

public class StudentNotFoundException extends RuntimeException{
    //constructor
    // we can pass the message by our on way
    public StudentNotFoundException(String message) {
        super(message);

        //super mean call the constructor of the superclass
        // the message field had initialize, so we we dont have to create a message field
        //* we leverage the existing functionality of the exception class, avoiding the need to duplicates code that handles the error message
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
