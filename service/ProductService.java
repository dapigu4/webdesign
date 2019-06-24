package management.service;

import management.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> showProduct();
    Map addProduct(Product product);
    Map removeProduct(Product product);
}
