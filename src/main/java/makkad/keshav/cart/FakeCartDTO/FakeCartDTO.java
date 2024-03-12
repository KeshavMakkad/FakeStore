package makkad.keshav.cart.FakeCartDTO;

import lombok.Getter;
import lombok.Setter;
import makkad.keshav.cart.model.Product;

import java.util.*;
@Getter
@Setter
public class FakeCartDTO {
    int id;
    int userID;
    Date date;
    List<Product> products;
}
