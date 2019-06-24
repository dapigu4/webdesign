package management.service.impl;

import management.dao.ClientDao;
import management.dao.FlowDao;
import management.dao.SupplierDao;
import management.dao.WarehouseDao;
import management.pojo.Client;
import management.pojo.Flow;
import management.pojo.Supplier;
import management.pojo.Warehouse;
import management.service.FlowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class FlowServiceImpl implements FlowService {
    @Resource
    private WarehouseDao warehouseDao;
    @Resource
    private FlowDao flowDao;
    @Resource
    private SupplierDao supplierDao;
    @Resource
    private ClientDao clientDao;

    //入库先看一下是不是已经有了，供应商是不是存在，如果有就直接改数量，没有就整个添加
    @Override
    public Map flowInput(Flow flow) {
        HashMap<String, String> hashMap = new HashMap<>();
        Warehouse warehouse = new Warehouse();
        flow2Warehouse(flow, warehouse);
        int result = -1;
        Supplier supplier = new Supplier();
        supplier.setSupplierName(flow.getSupplyOrDemand());
        if (supplierDao.findSupplier(supplier) != null){
            if (warehouseDao.findWarehouseByName(warehouse) != null) {
                result = warehouseDao.warehouseInput(warehouse);
            } else {
                result = warehouseDao.warehouseInputFirstTime(warehouse);
            }
        }

        if (result > 0) {
            flow.setInOrOut("I");
            flowDao.flowInputOrOutput(flow);
            hashMap.put("msg", "success");
        } else {
            hashMap.put("msg", "fail");
        }
        return hashMap;
    }

    //出库看一下是不是已经有了,客户是不是存在，如果有了就改数量，没有或数量不够就报错
    @Override
    public Map flowOutput(Flow flow) {
        HashMap<String, String> hashMap = new HashMap<>();
        int result = -1;
        Warehouse temp;
        Warehouse warehouse = new Warehouse();
        flow2Warehouse(flow, warehouse);
        int stocks;
        Client client = new Client();
        client.setClientName(flow.getSupplyOrDemand());
        if(clientDao.findClient(client) != null){
            if ((temp = warehouseDao.findWarehouseByName(warehouse)) != null) {
                stocks = temp.getStocks();
                if (stocks < warehouse.getStocks()) {
                    hashMap.put("msg", "don't have enough stocks");
                } else {
                    result = warehouseDao.warehouseOutput(warehouse);
                }
            } else {
                hashMap.put("msg", "don't have this product");
            }
        }

        if (result > 0) {
            flow.setInOrOut("O");
            flowDao.flowInputOrOutput(flow);
            hashMap.put("msg", "success");
        }else {
            hashMap.put("msg", "fail");
        }
        return hashMap;
    }

    @Override
    public List<Warehouse> showWarehouse() {
        return warehouseDao.showWarehouse();
    }

    @Override
    public List<Flow> showFlow() {
        List<Flow> list = flowDao.showFlow();
        for (Flow flow:list) {
            if("I".equals(flow.getInOrOut())){
                flow.setInOrOut("入库");
            }else if("O".equals(flow.getInOrOut())){
                flow.setInOrOut("出库");
            }else {
                flow.setInOrOut("未知");
            }
        }
        return list;
    }

    private void flow2Warehouse(Flow flow, Warehouse warehouse) {
        warehouse.setName(flow.getProductName());
        warehouse.setSize(flow.getSize());
        warehouse.setCost(flow.getPerCost());
        warehouse.setSell(flow.getPerSell());
        warehouse.setStocks(flow.getCount());
    }
}
