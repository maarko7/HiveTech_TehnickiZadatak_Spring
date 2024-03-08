package dev.ms.production.service;

import dev.ms.production.entity.PhonebookUser;
import dev.ms.production.repository.PhonebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhonebookServiceImpl implements PhonebookService{

    @Autowired
    private PhonebookRepository phonebookRepository;


    @Override
    public List<PhonebookUser> getAllUsers() {
        return phonebookRepository.findAll();
    }

    @Override
    public PhonebookUser addUser(PhonebookUser user) {
        return phonebookRepository.save(user);
    }

    @Override
    public PhonebookUser getUserById(Long userId) {
        Optional<PhonebookUser> userOptional = phonebookRepository.findById(userId);
        return userOptional.orElse(null);
    }

    @Override
    public PhonebookUser updateUser(Long userId, PhonebookUser user) {
        Optional<PhonebookUser> userOptional = phonebookRepository.findById(userId);
        if (userOptional.isPresent()) {
            PhonebookUser existingUser = userOptional.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setCity(user.getCity());
            existingUser.setPhoneNumber(user.getPhoneNumber());

            return phonebookRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
