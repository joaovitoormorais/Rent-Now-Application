package rentnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentnow.enums.SpecType;
import rentnow.model.Rent;
import rentnow.model.RentSpec;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentSpecRepository extends JpaRepository<RentSpec, Long> {

   List<RentSpec> findByRent(Rent rent);

   Optional<RentSpec> findBySpecType(SpecType specType);

   Optional<RentSpec> findBySpecValue(String specValue);

   void deleteById(Long rentSpecId);
}