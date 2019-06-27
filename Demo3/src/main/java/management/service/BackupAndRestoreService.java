package management.service;

import management.pojo.Table;

import java.util.Map;

public interface BackupAndRestoreService {
    Map backup();
    Map restore();
}
