package Ecommerce.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public record RegisterRequest(String firstName, String lastName, String email, String password) {

}
