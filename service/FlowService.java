package management.service;

import management.pojo.Flow;
import management.pojo.Warehouse;

import java.util.List;
import java.util.Map;


public interface FlowService {
    Map flowInput(Flow flow);//之后的入库直接改数量
    Map flowOutput(Flow flow);//出库直接修改数量
    List<Warehouse> showWarehouse();
    List<Flow> showFlow();
}
