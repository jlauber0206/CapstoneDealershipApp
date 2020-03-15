package dealershipapplicationB.ExceptionHandling;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class Exceptions extends RuntimeException {

    private static final long serialVersionUID = 1L ;

    public Exceptions(String message) {
        super(message);
    }

    public Exceptions(String message, Throwable throwable) {
        super(message, throwable);
    }

}
