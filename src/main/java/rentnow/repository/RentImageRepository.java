package rentnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentnow.model.RentImage;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentImageRepository extends JpaRepository<RentImage, Long> {

    List<RentImage> findByRentId(Long rentId);

    Optional<RentImage> findByPath(String path);

    long countByRentId(Long rentId);

    void deleteByRentId(Long rentId);
}