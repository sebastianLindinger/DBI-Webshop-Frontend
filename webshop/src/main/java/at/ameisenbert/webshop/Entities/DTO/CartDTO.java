package at.ameisenbert.webshop.Entities.DTO;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CartDTO {
    private int userID;
    ArrayList<Integer> productIDs;
}
