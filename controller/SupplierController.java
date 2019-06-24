package management.controller;

import management.pojo.Supplier;
import management.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Resource
    private SupplierService supplierService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Supplier> list(){
        return supplierService.showSupplier();
    }

    @RequestMapping("/register")
    @ResponseBody
    public Map register(@RequestBody Supplier supplier){
       return supplierService.addSupplier(supplier);
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Map remove(@RequestBody Supplier supplier){
        return supplierService.removeSupplier(supplier);
    }

    @RequestMapping("/showbyname")
    @ResponseBody
    public Map showByName(@RequestBody Supplier supplier){
        return supplierService.findSupplier(supplier);
    }


}
