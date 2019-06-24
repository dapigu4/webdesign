package management.controller;

import management.pojo.Product;
import management.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Product> list(){
        return productService.showProduct();
    }

    @RequestMapping("/register")
    @ResponseBody
    public Map register(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Map remove(@RequestBody Product product){
        return  productService.removeProduct(product);
    }
}
