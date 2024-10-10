package com.tns.B90_User;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserEntity> list() {
        return service.listAll();
    }

    @GetMapping("/{userid}")
    public ResponseEntity<UserEntity> get(@PathVariable Integer userid) {
        try {
            UserEntity user = service.get(userid);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity user) {
        service.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{userid}")
    public ResponseEntity<?> update(@RequestBody UserEntity user, @PathVariable Integer userid) {
        try {
            UserEntity existUserEntity = service.get(userid);
            user.setUserid(userid);
            service.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<?> delete(@PathVariable Integer userid) {
        try {
            service.delete(userid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}