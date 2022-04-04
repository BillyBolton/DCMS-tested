package ca.me.proj.dtos.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiError {

    String message;
    Throwable cause;
    int status;

}
