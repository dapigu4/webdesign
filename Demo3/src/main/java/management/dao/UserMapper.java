package management.dao;

import management.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserByUsername(String name);
}
