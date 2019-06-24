package management.service.impl;

import management.dao.ProductDao;
import management.pojo.Product;
import management.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;
    @Override
    public List<Product> showProduct() {
        return productDao.showProduct();
    }

    @Override
    public Map addProduct(Product product) {
        Map<String,String> map = new HashMap<>();
        int result = productDao.addProduct(product);
        if(result>0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Map removeProduct(Product product) {
        Map<String,String> map = new HashMap<>();
        int result = productDao.removeProduct(product);
        if(result>0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }
}
