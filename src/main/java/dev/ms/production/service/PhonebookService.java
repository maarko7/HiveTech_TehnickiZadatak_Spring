package dev.ms.production.service;

import dev.ms.production.entity.PhonebookUser;

import java.util.List;
import java.util.Optional;

public interface PhonebookService {
    List<PhonebookUser> getAllUsers();

    PhonebookUser addUser(PhonebookUser users);

    Optional<PhonebookUser> getUserById(Long userId);

    Optional<List<PhonebookUser>> getUserByFirstName(String firstName);

    Optional<List<PhonebookUser>> getUserByLastName(String lastName);

    Optional<PhonebookUser> getUserByPhoneNumber(Long phoneNumber);

    PhonebookUser updateUser(Long userId, PhonebookUser user);

    void deleteUser(Long userId);
}
