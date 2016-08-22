package blog.services;

public interface UserService {
    boolean authenticate(String username, String password);
    boolean registerValidation (String username); //check if username is present in db
}
