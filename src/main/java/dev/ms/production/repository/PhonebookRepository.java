package dev.ms.production.repository;

import dev.ms.production.entity.PhonebookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhonebookRepository extends JpaRepository<PhonebookUser, Long> {
    Optional<PhonebookUser> findByOib(String oib);

    Optional<List<PhonebookUser>> findByFirstName(String firstName);

    Optional<List<PhonebookUser>> findByLastName(String lastName);

    Optional<PhonebookUser> findByPhoneNumber(String phoneNumber);
}
