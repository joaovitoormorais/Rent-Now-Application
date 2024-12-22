package rentnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentnow.model.RentImage;

import java.util.List;

@Repository
public interface RentImageRepository extends JpaRepository<RentImage, Long> {

}
