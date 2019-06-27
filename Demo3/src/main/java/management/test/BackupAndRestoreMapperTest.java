package management.test;

import management.service.BackupAndRestoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BackupAndRestoreMapperTest {
    @Resource
    private BackupAndRestoreService backupAndRestoreService;

    @Test
    public void test1(){
        System.out.println(backupAndRestoreService.backup());
    }

    @Test
    public void test2(){
        System.out.println(backupAndRestoreService.restore());
    }
}
