package GestionaleDatabase.repository;

import GestionaleDatabase.entity.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdministratorRepository extends JpaRepository<AdministratorEntity, Long> {
}
