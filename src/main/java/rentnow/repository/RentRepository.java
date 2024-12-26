package rentnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rentnow.model.Rent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface RentRepository extends JpaRepository<Rent, UUID> {

    List<Rent> findByDescriptionIgnoreCase();

    List<Rent> findByRentCondominiumBetween(double minPrice, double maxPrice);

    List<Rent> findBySummaryContainingIgnoreCase(String keyword);

    List<Rent> findByCreateAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT * FROM rents WHERE rent_price > :price", nativeQuery = true)
    List<Rent> findByPriceGreatherThan(@Param("price") double price);

    boolean existById(UUID uuid);
}