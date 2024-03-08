package dev.ms.production.service;

import dev.ms.production.entity.PhonebookUser;

import java.util.List;

public interface PhonebookService {
    List<PhonebookUser> getAllUsers();
    PhonebookUser addUser(PhonebookUser user);
    PhonebookUser getUserById(Long userId);
    PhonebookUser updateUser(Long userId, PhonebookUser user);
    void deleteUser(Long userId);
}
