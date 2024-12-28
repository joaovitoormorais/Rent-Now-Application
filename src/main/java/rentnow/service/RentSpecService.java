package rentnow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rentnow.model.RentSpec;
import rentnow.repository.RentSpecRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RentSpecService {

    @Autowired
    private RentSpecRepository rentSpecRepository;

    public RentSpec saveRentSpec(RentSpec rentSpec) {
        return rentSpecRepository.save(rentSpec);
    }

    public List<RentSpec> getAllRentSpec() {
        return rentSpecRepository.findAll();
    }

    public Optional<RentSpec> getRentSpecById(Long rentSpecId) {
        return rentSpecRepository.findById(rentSpecId);
    }

    public Optional<RentSpec> updateRentSpec(Long rentSpecId, RentSpec rentSpec) {
        return rentSpecRepository.findById(rentSpecId).map(existingRentSpec -> {
           existingRentSpec.setSpecValue(rentSpec.getSpecValue());
           existingRentSpec.setRent(rentSpec.getRent());
           existingRentSpec.setSpecType(rentSpec.getSpecType());
           return rentSpecRepository.save(existingRentSpec);

        });

    }

    public boolean deleteRentSpec(Long rentSpecId) {
        if(rentSpecRepository.existsById(rentSpecId)) {
            rentSpecRepository.deleteById(rentSpecId);
            return true;
    }
        return false;
}
}