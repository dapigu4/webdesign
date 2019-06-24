package management.dao;

import management.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    List<Product> showProduct();
    int addProduct(Product product);
    int removeProduct(Product product);
}
