package management.service.impl;

import management.pojo.User;
import management.dao.UserMapper;
import management.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userDao;

    @Override
    public User getUserByUsername(String name) {
        return userDao.getUserByUsername(name);
    }
}
