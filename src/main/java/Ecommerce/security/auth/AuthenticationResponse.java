package Ecommerce.security.auth;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public record AuthenticationResponse(String token) {
}
