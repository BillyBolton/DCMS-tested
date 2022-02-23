
package ca.me.proj.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

    public ResourceAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public ResourceAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAlreadyExistsException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
