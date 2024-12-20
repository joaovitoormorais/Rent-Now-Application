package rentnow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import rentnow.model.RentImage;
import rentnow.repository.RentImageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RentImageService {

    @Autowired
    private RentImageRepository rentImageRepository;

    public RentImage rentImage(RentImage rentImage) {
        return rentImageRepository.save(rentImage);
    }

    public List<RentImage> getAllRentImages() {
        return rentImageRepository.findAll();
  }

    public Optional<RentImage> getRentImagesById(Long id) {
        return rentImageRepository.findById(id);

  }
    public Optional<RentImage> updateRentImages(Long id, RentImage rentImage) {
        return rentImageRepository.findById(id).map(existingRentImage -> {
            existingRentImage.setRentImageId(rentImage.getRentImageId());
            existingRentImage.setPath(rentImage.getPath());
            return rentImageRepository.save(existingRentImage);
    });

    }

    public boolean deleteRentImages(Long id) {
        if(rentImageRepository.existsById(id)) {
            rentImageRepository.deleteById(id);
            return true;
        }
            return false;
    }

    public RentImage saveRentImage(RentImage rentImage) {
        return rentImageRepository.save(rentImage);
    }
}





