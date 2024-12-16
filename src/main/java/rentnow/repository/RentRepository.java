package rentnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentnow.model.Rent;

import java.util.UUID;

@Repository
public interface RentRepository extends JpaRepository<Rent, UUID> {
}
