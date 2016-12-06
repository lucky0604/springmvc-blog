package blog.services;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by lucky on 12/6/16.
 */
@Service
public class UserServiceStubImpl implements UserService {

    @Override
    public boolean authenticate(String username, String password) {
        // 最简单的密码验证：username == password
        return Objects.equals(username, password);
    }
}
