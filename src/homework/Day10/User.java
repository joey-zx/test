package homework.Day10;

import java.util.Objects;

public class User {
    private String username;
    private String password;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;


        if (this.getUsername() == null) {
            if (user.getUsername() != null) {
                return false;
            }
        } else if (!this.getUsername().equals(user.getUsername())) {
            return false;
        }


        if (this.getPassword() == null) {
            if (user.getPassword() != null) {
                return false;
            } else if (!this.getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }
}
