package at.ameisenbert.webshop.Entities.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data @AllArgsConstructor
public class OrderResource {
    private int orderID;
    private String orderDate;
    private int userID;
    private ArrayList<Integer> productIDs;
}
