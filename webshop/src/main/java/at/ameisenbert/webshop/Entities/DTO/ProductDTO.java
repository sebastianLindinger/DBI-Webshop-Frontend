package at.ameisenbert.webshop.Entities.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private double weight;
    private double price;
    private String image;
}
