package makkad.keshav.cart.service;

import makkad.keshav.cart.model.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public interface CartService {
    Cart getSingleProduct();

    public List<Cart> getAllCarts();

    public Cart getSingleCart(int id);

    public List<Cart> getUserCart(int userID);

    public Cart addNewCart(@RequestBody Cart cart);

    public void deleteCart(int id);

}
