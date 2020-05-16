package homework.EqualsTest;

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
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null) {
            return false;
        }

        if(getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;


        if(!(this.username == user.username || this.username != null && this.username.equals(user.username))) {
            return false;
        }

        if(!(this.password == user.password || this.password != null && this.password.equals(user.password))) {
            return false;
        }

        return true;
    }
}
