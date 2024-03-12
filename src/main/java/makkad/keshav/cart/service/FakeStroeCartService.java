package makkad.keshav.cart.service;

import makkad.keshav.cart.FakeCartDTO.FakeCartDTO;
import makkad.keshav.cart.model.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FakeStroeCartService implements CartService {
    private final RestTemplate restTemp;

    public FakeStroeCartService() {
        restTemp = new RestTemplate();
    }

    @Override
    public Cart getSingleCart(int id){
        FakeCartDTO fakeCartDTO = restTemp.getForObject(
                "https://fakestoreapi.com/carts/" + id,
                FakeCartDTO.class
        );
        assert fakeCartDTO != null;
        return setDTOToCart(fakeCartDTO);
    };

    @Override
    public List<Cart> getUserCart(int userID){
        List<FakeCartDTO> fakeCartDTOList = Collections.singletonList(restTemp.getForObject(
                "https://fakestoreapi.com/carts/user/" + userID,
                FakeCartDTO.class
        ));

        List<Cart> allCartsList = new ArrayList<>();

        for (FakeCartDTO cartDTO : fakeCartDTOList) {
            Cart cart = setDTOToCart(cartDTO);
            allCartsList.add(cart);
        }
        return allCartsList;
    }

    @Override
    public Cart addNewCart(@RequestBody Cart cart){
        FakeCartDTO dto = cartToDTO(cart);

        FakeCartDTO fakeCartDTO = restTemp.postForObject(
                "https://fakestoreapi.com/carts",
                dto,
                FakeCartDTO.class
        );

        return getSingleCart(cart.getId());
    }

    @Override
    public Cart getSingleProduct() {
        return null;
    }

    @Override
    public List<Cart> getAllCarts() {
        List<FakeCartDTO> fakeCartDTOList = Collections.singletonList(restTemp.getForObject(
                "https://fakestoreapi.com/carts",
                FakeCartDTO.class

        ));

        List<Cart> allCartsList = new ArrayList<Cart>();
        for (FakeCartDTO cartDTO : fakeCartDTOList) {
            Cart cart = setDTOToCart(cartDTO);
            allCartsList.add(cart);
        }
        return allCartsList;
    }

    @Override
    public void deleteCart(int id) {
        restTemp.delete(
                "https://fakestoreapi.com/carts/" + id
        );
    }

    private FakeCartDTO cartToDTO(Cart cart){
        FakeCartDTO dto = new FakeCartDTO();
        dto.setId(cart.getId());
        dto.setUserID(cart.getUserID());
        dto.setDate(cart.getDate());
        dto.setProducts(cart.getProducts());

        return dto;
    }

    private Cart setDTOToCart(FakeCartDTO fakeCartDTO){
        Cart newCart = new Cart();
        newCart.setId(fakeCartDTO.getId());
        newCart.setUserID(fakeCartDTO.getUserID());
        newCart.setDate(fakeCartDTO.getDate());
        newCart.setProducts(fakeCartDTO.getProducts());

        return newCart;
    }


}
