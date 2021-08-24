package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    @Query("from people where cpf like %:cpf%")
    People findByCPF(String cpf);
}
