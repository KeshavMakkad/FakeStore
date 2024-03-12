package makkad.keshav.cart.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Cart {
    int id;
    int UserID;
    Date date;
    List<Product> products;
}
