package blog.services;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceStubImpl implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
        //sample password check (username == password)
        return Objects.equals(username,password);
    }
}
