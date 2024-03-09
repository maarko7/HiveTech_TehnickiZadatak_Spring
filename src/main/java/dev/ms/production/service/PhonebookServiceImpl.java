package dev.ms.production.service;

import dev.ms.production.entity.PhonebookUser;
import dev.ms.production.repository.PhonebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public Optional<PhonebookUser> getUserById(Long userId) {
        return phonebookRepository.findById(userId);
    }

    @Override
    public Optional<PhonebookUser> getUserByOib(String  oib) {
        return phonebookRepository.findByOib(oib);
    }

    @Override
    public Optional<List<PhonebookUser>> getUserByFirstName(String firstName) {
        return phonebookRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<List<PhonebookUser>> getUserByLastName(String lastName) {
        return phonebookRepository.findByLastName(lastName);
    }

    @Override
    public Optional<PhonebookUser> getUserByPhoneNumber(String phoneNumber) {
        return phonebookRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public PhonebookUser updateUser(Long userId, PhonebookUser user) {
        PhonebookUser userDB = phonebookRepository.findById(userId).get();

        if (Objects.nonNull(user.getFirstName())
                && !"".equalsIgnoreCase(user.getFirstName())) {
            userDB.setFirstName(user.getFirstName());
        }

        if (Objects.nonNull(user.getLastName())
                && !"".equalsIgnoreCase(user.getLastName())) {
            userDB.setLastName(user.getLastName());
        }

        if (Objects.nonNull(user.getCity())
                && !"".equalsIgnoreCase(user.getCity())) {
            userDB.setCity(user.getCity());
        }

        if (Objects.nonNull(user.getPhoneNumber())) {
            userDB.setPhoneNumber(user.getPhoneNumber());
        }

        return phonebookRepository.save(userDB);
    }

    @Override
    public void deleteUser(Long userId) {
        phonebookRepository.deleteById(userId);
    }
}
