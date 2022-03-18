package ca.me.proj.entity.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponseEntity {

    // Default Constructor
    private CustomResponseEntity() {}

    public static ResponseEntity<String> updateSuccess() {
        return new ResponseEntity<>("SUCCESS - Entity updated", HttpStatus.OK);
    }

    public static ResponseEntity<String> saveSuccess() {
        return new ResponseEntity<>("SUCCESS - Entity saved", HttpStatus.OK);
    }

    public static ResponseEntity<String> deleteSuccess() {
        return new ResponseEntity<>("SUCCESS - Entity deleted", HttpStatus.OK);
    }

    public static ResponseEntity<String> badRequestDNE() {
        return new ResponseEntity<>("BAD REQUEST - Entity does not exist", HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<String> badRequestInvalidArgument() {
        return new ResponseEntity<>("BAD REQUEST - Invalid arguments", HttpStatus.BAD_REQUEST);
    }

}
