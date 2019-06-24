package management.service;

import management.pojo.Supplier;

import java.util.List;
import java.util.Map;

public interface SupplierService {
    List<Supplier> showSupplier();
    Map addSupplier(Supplier supplier);
    Map removeSupplier(Supplier supplier);
    Map findSupplier(Supplier supplier);
}
