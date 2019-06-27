package management.dao;

import management.pojo.Table;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BackupDao {
    int backup(Table table);
    List<String> findAllTableName();
}
