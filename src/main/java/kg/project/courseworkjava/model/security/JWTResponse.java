package kg.project.courseworkjava.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JWTResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;

    private List<String> permission;

    public JWTResponse(String token, Long id, String username) {
        this.token = token;
        this.id = id;
        this.username = username;
    }
}