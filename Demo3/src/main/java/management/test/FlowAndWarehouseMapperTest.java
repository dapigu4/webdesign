package management.test;

import management.pojo.Flow;
import management.service.FlowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class FlowAndWarehouseMapperTest {
    @Resource
    private FlowService flowService;

    @Test
    public void test1(){
//        System.out.println(flowService.showFlow());
    }

    @Test
    public void test2(){
        System.out.println(flowService.showWarehouse());
    }

    @Test
    public void test3(){
        Flow flow = new Flow();
        flow.setFlowDate(new Date());
        flow.setPerCost(15.0);
        flow.setPerSell(30.0);
        flow.setProductName("拖孩");
        flow.setSize("50码");
        flow.setSupplyOrDemand("华师");
        flow.setCount(10);
        flow.setInOrOut("I");
        flow.setTotal(43.0);
        System.out.println(flowService.flowInput(flow));
    }

    @Test
    public void test4(){
        Flow flow = new Flow();
        flow.setFlowDate(new Date());
        flow.setPerCost(15.0);
        flow.setPerSell(30.0);
        flow.setProductName("拖孩");
        flow.setSize("50码");
        flow.setSupplyOrDemand("付款后话框");
        flow.setCount(5);
        flow.setInOrOut("O");
        flow.setTotal(43.0);
        System.out.println(flowService.flowOutput(flow));
    }
}
