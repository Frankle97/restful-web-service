package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Kenneth", new Date(), "password1", "700101-1111111"));
        users.add(new User(2, "Alice", new Date(), "password2", "7865436-1637543"));
        users.add(new User(3, "Kevin", new Date(), "password3", "7905667-7654858"));
    }

    public List<User> findAll() {
       return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }

}
