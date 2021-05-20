package at.ameisenbert.webshop.Entities.DTO;

import lombok.Data;

import java.util.ArrayList;

@Data
public class OrderDTO {
    private int userID;
    private ArrayList<Integer> productIDs;
}
