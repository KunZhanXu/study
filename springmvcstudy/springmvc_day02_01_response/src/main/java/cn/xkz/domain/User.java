package cn.xkz.domain;

import java.io.Serializable;

public class User implements Serializable {
=======
public class User implements Serializable{

>>>>>>> 37b7324e6cd91733deb227f6579556ceced6668a
    private String username;
    private String password;
    private Integer age;

<<<<<<< HEAD
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

=======
>>>>>>> 37b7324e6cd91733deb227f6579556ceced6668a
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
