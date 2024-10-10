 package com.tns.B90_User;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<UserEntity> listAll() {
        return repo.findAll();
    }

    public void save(UserEntity user) {
        repo.save(user);
    }

    public UserEntity get(Integer userid) {
        return repo.findById(userid).orElse(null);
    }

    public void delete(Integer userid) {
        repo.deleteById(userid);
    }
}
