package management.test;

import management.pojo.Product;
import management.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductMapperTest {
    @Resource
    private ProductService productService;

    @Test
    public void test1(){
       System.out.println(productService.showProduct());
    }

    @Test
    public void test2(){
        Product product = new Product();
        product.setProductName("捞头");
        product.setProductSize("sl深刻见风使舵");
        product.setProductCost(444.0);
        product.setProductSell(555.0);
        product.setProductProfit(111.0);
        System.out.println(productService.addProduct(product));
    }

    @Test
    public void test3(){
        Product product = new Product();
        product.setProductName("捞头");
        System.out.println(productService.removeProduct(product));
    }
}
