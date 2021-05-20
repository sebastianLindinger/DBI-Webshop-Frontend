package at.ameisenbert.webshop.Entities.Resource;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserResource {
    private int userID;
    private String userName;
    private String email;
}
