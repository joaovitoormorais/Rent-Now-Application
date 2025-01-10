package rentnow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rentnow.dto.RentRecordDto;
import rentnow.model.Rent;
import rentnow.repository.RentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    public Optional<Rent> getRentById(UUID uuid) {
        return rentRepository.findById(uuid);
    }

    public Rent saveRent(Rent rent) {
        return rentRepository.save(rent);
    }

  public Optional<Rent> updateRent(UUID uuid, RentRecordDto rentRecordDto) {

        Optional<Rent> optionalRent = rentRepository.findById(uuid);

       if(optionalRent.isPresent()) {
           Rent existingRent = optionalRent.get();
           existingRent.setRentFess(rentRecordDto.rentFess());
           existingRent.setRentCondominium(rentRecordDto.rentCondominium());
           existingRent.setSummary(rentRecordDto.summary());
           existingRent.setDescription(rentRecordDto.description());
           existingRent.setCreateAt(rentRecordDto.createAt());

           Rent updateRent = rentRepository.save(existingRent);

           return Optional.of(updateRent);
        }

       return Optional.empty();
  }

  public boolean deleteRent(UUID uuid) {
        return rentRepository.findById(uuid).map(rent -> {
            rentRepository.delete(rent);
            return true;

                }).orElse(false);
  }

        }