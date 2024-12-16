package jwt.projectjwt.domain.user;

public record RegisterDTO(String username, String password, UserRole role) {
}
