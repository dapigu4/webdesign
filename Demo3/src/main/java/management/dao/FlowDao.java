package management.dao;

import management.pojo.Flow;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowDao {
    int flowInputOrOutput(Flow flow);
    List<Flow> showFlow(Flow flow);
}
