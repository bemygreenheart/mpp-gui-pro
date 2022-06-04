package uz.group.mppguiproject.config;

import uz.group.mppguiproject.entity.Role;
import uz.group.mppguiproject.entity.User;

public final class Session {

    private static Session instance;

    private User user;

    private Session() {
        this.user = null;
    }


    public static Session createInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public static void destroySession() {
        instance = null;
    }

    public static Session getInstance() {
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Role getRole() {
        return user == null ? null : user.getRole();
    }

}