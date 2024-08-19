package dev.sunil.Asq.maintenance.repository;

import dev.sunil.Asq.maintenance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
