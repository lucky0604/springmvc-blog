package blog.services;

/**
 * Created by lucky on 12/6/16.
 */
public interface UserService {
    boolean authenticate(String username, String password);
}
