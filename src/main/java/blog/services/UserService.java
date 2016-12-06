package blog.services;

import blog.models.User;

import java.util.List;

/**
 * Created by lucky on 12/6/16.
 */
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}
