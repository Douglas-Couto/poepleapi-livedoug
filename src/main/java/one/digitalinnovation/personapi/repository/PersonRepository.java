package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Apenas criando esta interface o Spring boot ja da as atividades basicas de um BD para nós, graças ao JpaRepo
}
