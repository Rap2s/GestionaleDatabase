package GestionaleDatabase.repository;

import GestionaleDatabase.entity.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<AdministratorEntity, Long> {

    @Query(value = "SELECT * FROM administrator WHERE username = :username AND password = :password", nativeQuery = true)
    Optional<AdministratorEntity> findByUsernameAndPassword(@Param("username") String username, @Param ("password") String password);

}
