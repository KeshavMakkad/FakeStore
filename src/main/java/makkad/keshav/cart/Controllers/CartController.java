package makkad.keshav.cart.Controllers;

import makkad.keshav.cart.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import makkad.keshav.cart.service.CartService;

import java.util.*;

@RestController
public class CartController {


    private CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public List<Cart> getAllProducts(){
        return cartService.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    Cart getSingleCart(@PathVariable("id") int id) {

        return cartService.getSingleCart(id);
    }
    @GetMapping("carts/user/{userID}")
    public List<Cart> getUserCart(int userID){
        return cartService.getUserCart(userID);
    }

    @PostMapping("carts")
    Cart addNewCart(@RequestBody Cart cart){
        return cartService.addNewCart(cart);
    }

    @DeleteMapping("carts/{id}")
    public void deleteCart(int id){
        cartService.deleteCart(id);
    }





}
