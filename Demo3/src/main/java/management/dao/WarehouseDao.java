package management.dao;

import management.pojo.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseDao {
    int warehouseInputFirstTime(Warehouse warehouse);//第一次入库
    int warehouseInput(Warehouse warehouse);//之后的入库直接改数量
    int warehouseOutput(Warehouse warehouse);//出库直接修改数量
    List<Warehouse> showWarehouse();
    int showWarehouseStocks(Warehouse warehouse);
    Warehouse findWarehouseByName(Warehouse warehouse);
}
