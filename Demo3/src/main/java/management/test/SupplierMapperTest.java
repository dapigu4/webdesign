package management.test;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import management.pojo.Supplier;
import management.service.SupplierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SupplierMapperTest {
    @Resource
    private SupplierService supplierService;

    @Test
    public void test1(){
        System.out.println(supplierService.showSupplier());
    }

    @Test
    public void test2(){
        Supplier supplier = new Supplier();
        supplier.setSupplierName("捞头");
        supplier.setSupplierContact("小华");
        supplier.setSupplierPhone("12314996476");
        supplier.setSupplierAddress("广州");
        supplier.setSupplierSex("男");
        supplier.setSupplierEmail("ajfkhkjds@sdfk.com");
        System.out.println(supplierService.addSupplier(supplier));
    }

    @Test
    public void test3(){
        Supplier supplier = new Supplier();
        supplier.setSupplierName("华师");
        System.out.println(supplierService.removeSupplier(supplier));
    }
    @Test
    public void test4(){
        Supplier supplier = new Supplier();
        supplier.setSupplierName("华师");
        System.out.println(supplierService.findSupplier(supplier));
    }
}
