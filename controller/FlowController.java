package management.controller;

import management.pojo.Flow;
import management.pojo.Warehouse;
import management.service.FlowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/flow")
public class FlowController {
    @Resource
    private FlowService flowService;

    @RequestMapping("/flowlist")
    @ResponseBody
    public List<Flow> flowList(){//查看仓库
        return flowService.showFlow();
    }

    @RequestMapping("/input")
    @ResponseBody
    public Map input(@RequestBody Flow flow){
        return flowService.flowInput(flow);
    }

    @RequestMapping("/output")
    @ResponseBody
    public Map output(@RequestBody Flow flow){
        return flowService.flowOutput(flow);
    }

    @RequestMapping("/warehouselist")
    @ResponseBody
    public List<Warehouse> warehouseList(){//查看明细
        return flowService.showWarehouse();
    }
}
