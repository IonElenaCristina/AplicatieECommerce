package Ecommerce.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


public record ApiResponse(boolean succes,String message) {

    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }

}
