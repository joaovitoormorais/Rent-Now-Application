package rentnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentnow.model.RentSpec;

@Repository
public interface RentSpecRepository extends JpaRepository<RentSpec, Long> {
}
