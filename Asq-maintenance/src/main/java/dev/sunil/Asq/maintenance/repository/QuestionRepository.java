package dev.sunil.Asq.maintenance.repository;

import dev.sunil.Asq.maintenance.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
}
