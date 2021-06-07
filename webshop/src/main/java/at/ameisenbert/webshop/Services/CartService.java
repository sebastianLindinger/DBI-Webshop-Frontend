package at.ameisenbert.webshop.Services;

import at.ameisenbert.webshop.Entities.DB.CartDB;
import at.ameisenbert.webshop.Entities.DTO.CartDTO;
import at.ameisenbert.webshop.Entities.DTO.ProductDTO;
import at.ameisenbert.webshop.Entities.Resource.CartResource;
import at.ameisenbert.webshop.Exceptions.BadRequestException;
import at.ameisenbert.webshop.Exceptions.NotFoundException;
import at.ameisenbert.webshop.Repositories.CartRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    //@PostConstruct
    public void initCart() {
        CartDB cart1 = new CartDB(1, 1, new ArrayList<>(Arrays.asList(new Integer[] {3,2})));
        cartRepository.save(cart1);
    }

    public CartResource getCartResourceById(int id) { return cartToCartResource( getCartById(id)); }

    private CartDB getCartById(int id) {
        Optional<CartDB> cart = cartRepository.findById(id);
        if(cart.isPresent()) return cart.get();
        else throw new NotFoundException("Cart with the id " + id + " was not found.");
    }

    private CartResource cartToCartResource(CartDB cart) { return new CartResource(cart.getCartID(), cart.getUserID(), cart.getProductIDs());  }

    public List<CartResource> getCartResources() {
        return cartRepository.findAll().stream()
                .map(cart -> new CartResource(cart.getCartID(), cart.getUserID(), cart.getProductIDs()))
                .collect(Collectors.toList());
    }

    public CartResource addCart(CartDTO cartDTO) {
        checkCartDTO(cartDTO);

        CartDB cart = new CartDB(null, cartDTO.getUserID(), cartDTO.getProductIDs());
        cart = cartRepository.save(cart);
        return cartToCartResource(cart);
    }

    private void checkCartDTO(CartDTO cartDTO) {
        if(cartDTO.getUserID() == 0) throw new BadRequestException("User ID must be set");
    }

    public CartResource updateCart(int id, CartDTO cartDTO) {
        CartDB cart = getCartById(id);

        if(cartDTO.getProductIDs() != null)
            cart.setProductIDs(cartDTO.getProductIDs());

        if(cartDTO.getUserID() != 0)
            cart.setUserID(cartDTO.getUserID());

        cartRepository.save(cart);

        return cartToCartResource(cart);
    }

    public CartResource deleteCart(int id) {
        CartDB cart = getCartById(id);

        cartRepository.delete(cart);
        return cartToCartResource(cart);
    }

    public CartResource getCartResourceFromUser(int id) {
        Optional<CartResource> optionalCartResource =  cartRepository.findAll().stream()
                .filter(cart -> cart.getUserID() == id)
                .map(cart -> new CartResource(cart.getCartID(), cart.getUserID(), cart.getProductIDs()))
                .findFirst();

        if(optionalCartResource.isPresent()) return optionalCartResource.get();
        else throw new NotFoundException("Cart with the id " + id + " was not found.");
    }

    public CartResource addProduct(int id, int idProduct) {
        CartDB cart = getCartById(id);
        ArrayList<Integer> productIDs = cart.getProductIDs();
        productIDs.add(idProduct);
        cartRepository.save(cart);
        return cartToCartResource(cart);
    }
}
