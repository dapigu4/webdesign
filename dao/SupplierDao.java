package management.dao;

import management.pojo.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierDao {
    List<Supplier> showSupplier();
    int addSupplier(Supplier supplier);
    int removeSupplier(Supplier supplier);
    Supplier findSupplier(Supplier supplier);
}
