package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterForm {
    private String fullName;

    @Size(min=2, max=30, message = "Username must be between 2 and 30 characters long.")
    private String username;

    @NotNull
    @Size(min=1, max=50, message = "Password must be between 1 and 50 characters long.")
    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

