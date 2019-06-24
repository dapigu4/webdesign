package management.service.impl;

import management.dao.SupplierDao;
import management.pojo.Supplier;
import management.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierDao supplierDao;

    @Override
    public List<Supplier> showSupplier() {
        List<Supplier> list = supplierDao.showSupplier();
        for (Supplier supplier:list) {
            if("m".equals(supplier.getSupplierSex())){
                supplier.setSupplierSex("男");
            }else {
                supplier.setSupplierSex("女");
            }
        }
        return list;
    }

    @Override
    public Map addSupplier(Supplier supplier) {
        Map<String,String> map = new HashMap<>();
        if (supplier.getSupplierSex().equals("男")){
            supplier.setSupplierSex("m");
        }else {
            supplier.setSupplierSex("f");
        }
        int result =supplierDao.addSupplier(supplier);
        if(result > 0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Map removeSupplier(Supplier supplier) {
        Map<String,String> map = new HashMap<>();
        int result =supplierDao.removeSupplier(supplier);
        if(result > 0){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @Override
    public Map findSupplier(Supplier supplier) {
        Map<String,String> map = new HashMap<>();
        Supplier temp = supplierDao.findSupplier(supplier);
        if (temp != null){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }
}
