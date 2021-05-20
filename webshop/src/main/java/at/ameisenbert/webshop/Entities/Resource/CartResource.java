package at.ameisenbert.webshop.Entities.Resource;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data @AllArgsConstructor
public class CartResource {
    private int cartID;
    private int userID;
    ArrayList<Integer> productIDs;
}
