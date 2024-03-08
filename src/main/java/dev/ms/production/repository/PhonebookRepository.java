package dev.ms.production.repository;

import dev.ms.production.entity.PhonebookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonebookRepository extends JpaRepository<PhonebookUser, Long> {
}
