package management.service.impl;

import javafx.scene.control.Tab;
import management.dao.BackupDao;
import management.dao.RestoreDao;
import management.pojo.Table;
import management.service.BackupAndRestoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BackupAndRestoreServiceImpl implements BackupAndRestoreService {
    @Resource
    private BackupDao backupDao;
    @Resource
    private RestoreDao restoreDao;
    @Override
    public Map backup() {
        Map<String,String> map = new HashMap<>();
        //找到全部表名字
        Table table = new Table();
        int result = -1;
        List<String> list = backupDao.findAllTableName();
        for (String name:list) {
            table.setTableName(name);
            table.setBackupTableName(name+"_backup");
            result = backupDao.backup(table);
            if(result>0){
                map.put("msg","success");
            }else {
                map.put("msg","fail");
                break;
            }
        }
        return map;
    }

    @Override
    public Map restore() {
        Map<String,String> map = new HashMap<>();
        //找到全部表名字
        Table table = new Table();
        int result = -1;
        List<String> list = backupDao.findAllTableName();
        for (String name:list) {
            table.setTableName(name);
            table.setBackupTableName(name+"_backup");
            restoreDao.truncateTable(table);
            result = restoreDao.restore(table);
            if(result>0){
                map.put("msg","success");
            }else {
                map.put("msg","fail");
                break;
            }
        }
        return map;
    }
}
