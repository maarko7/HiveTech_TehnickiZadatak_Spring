package dev.ms.production.controller;

import dev.ms.production.entity.PhonebookUser;
import dev.ms.production.service.PhonebookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phonebook")
public class PhonebookController {

    @Autowired
    private PhonebookService phonebookService;

    @GetMapping("/users")
    public List<PhonebookUser> getAllUsers() {
        return phonebookService.getAllUsers();
    }

    @PostMapping("/user")
    public PhonebookUser addUser(@Valid @RequestBody PhonebookUser user) {
        return phonebookService.addUser(user);
    }

    @GetMapping("/user/{id}")
    public Optional<PhonebookUser> getUserById(@PathVariable Long id) {
        return phonebookService.getUserById(id);
    }

    @GetMapping("user/oib/{oib}")
    public Optional<PhonebookUser> getUserByOib(@PathVariable String  oib) {
        return phonebookService.getUserByOib(oib);
    }

    @GetMapping("/user/firstname/{firstName}")
    public Optional<List<PhonebookUser>> getUserByFirstName(@PathVariable String firstName) {
        return phonebookService.getUserByFirstName(firstName);
    }

    @GetMapping("/user/lastname/{lastName}")
    public Optional<List<PhonebookUser>> getUserByLastName(@PathVariable String lastName) {
        return phonebookService.getUserByLastName(lastName);
    }

    @GetMapping("/user/phonenumber/{phoneNumber}")
    public Optional<PhonebookUser> getUserByPhoneNumber(@PathVariable String phoneNumber) {
        return phonebookService.getUserByPhoneNumber(phoneNumber);
    }

    @PutMapping("/user/{id}")
    public PhonebookUser updateUser(@PathVariable Long id, @RequestBody PhonebookUser user) {
        return phonebookService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        phonebookService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
