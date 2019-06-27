package management.dao;

import management.pojo.Table;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoreDao {
    void truncateTable(Table table);
    int restore(Table table);
}
