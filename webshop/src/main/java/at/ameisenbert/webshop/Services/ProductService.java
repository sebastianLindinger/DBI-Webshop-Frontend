package at.ameisenbert.webshop.Services;

import at.ameisenbert.webshop.Entities.DTO.ProductDTO;
import at.ameisenbert.webshop.Entities.DB.ProductDB;
import at.ameisenbert.webshop.Entities.Resource.ProductResource;
import at.ameisenbert.webshop.Exceptions.BadRequestException;
import at.ameisenbert.webshop.Exceptions.NotFoundException;
import at.ameisenbert.webshop.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //@PostConstruct
    public void initProducts() {
        ProductDB p = new ProductDB(1, "delfin", 15.00, 42.00, "assets/images/delfin.jpg");
        productRepository.save(p);
        ProductDB p2 = new ProductDB(2, "fisch", 69.69, 69.00, "assets/images/fisch.jpg");
        productRepository.save(p2);
    }

    public ProductResource getProductResourceById(int id) {
        return productToProductResource(getProductById(id));
    }

    private ProductDB getProductById(int id) {
        Optional<ProductDB> productDB = productRepository.findById(id);
        if (productDB.isPresent()) return productDB.get();
        else throw new NotFoundException("Product with the id " + id + " was not found");
    }

    private ProductResource productToProductResource(ProductDB product) {
        return new ProductResource(product.getProductID(), product.getName(), product.getWeight(), product.getPrice(), product.getImage());
    }

    public List<ProductResource> getProductResources() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResource(product.getProductID(), product.getName(), product.getWeight(), product.getPrice(), product.getImage()))
                .collect(Collectors.toList());
    }

    public ProductResource addProduct(ProductDTO productDTO) {
        checkProductDTO(productDTO);
        ProductDB product = new ProductDB(null, productDTO.getName(), productDTO.getWeight(), productDTO.getPrice(), productDTO.getImage());
        product = productRepository.save(product);
        return productToProductResource(product);
    }

    private void checkProductDTO(ProductDTO productDTO) {
        if (productDTO.getName().trim().equals("") || productDTO.getName() == null)
            throw new BadRequestException("Name must be set");
    }

    public ProductResource updateProduct(int id, ProductDTO productDTO) {
        ProductDB product = getProductById(id);

        if (productDTO.getName() != null && !productDTO.getName().trim().equals(""))
            product.setName(productDTO.getName());

        if (productDTO.getPrice() != 0)
            product.setPrice(productDTO.getPrice());

        if (productDTO.getWeight() != 0)
            product.setWeight(productDTO.getWeight());

        productRepository.save(product);

        return productToProductResource(product);
    }

    public ProductResource deleteProduct(int id) {
        ProductDB product = getProductById(id);

        productRepository.delete(product);
        return productToProductResource(product);
    }
}
