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
        return rentRepository.findById(uuid).map(existingRent -> {
        existingRent.setDescription(rentRecordDto.description());
        existingRent.setSummary(rentRecordDto.summary());
        existingRent.setRentCondominium(rentRecordDto.rentCondominium());
        existingRent.setRentFess(rentRecordDto.rentFess());
        existingRent.setCreateAt(rentRecordDto.createAt());

        return rentRepository.save(existingRent);

        });
  }

  public boolean deleteRent(UUID uuid) {
        return rentRepository.findById(uuid).map(rent -> {
            rentRepository.delete(rent);
            return true;

                }).orElse(false);
  }

        }