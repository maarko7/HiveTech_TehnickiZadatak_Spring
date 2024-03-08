package dev.ms.production.controller;

import dev.ms.production.entity.PhonebookUser;
import dev.ms.production.service.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phonebook")
public class PhonebookController {

    @Autowired
    private PhonebookService phonebookService;

    @GetMapping("/users")
    public ResponseEntity<List<PhonebookUser>> getAllUsers() {
        List<PhonebookUser> users = phonebookService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/user")
    public ResponseEntity<PhonebookUser> addUser(@RequestBody PhonebookUser user) {
        PhonebookUser createdUser = phonebookService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<PhonebookUser> getUserById(@PathVariable Long id) {
        PhonebookUser user = phonebookService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<PhonebookUser> updateUser(@PathVariable Long id, @RequestBody PhonebookUser user) {
        PhonebookUser updatedUser = phonebookService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        phonebookService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
