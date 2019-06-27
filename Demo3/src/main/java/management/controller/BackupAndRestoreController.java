package management.controller;

import management.service.BackupAndRestoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/backupandrestore")
public class BackupAndRestoreController {

    @Resource
    private BackupAndRestoreService backupAndRestoreService;

    @RequestMapping("/backup")
    @ResponseBody
    public Map backup(){
        return backupAndRestoreService.backup();
    }

    @RequestMapping("/restore")
    @ResponseBody
    public Map restore(){
        return backupAndRestoreService.restore();
    }
}
