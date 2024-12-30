package rentnow.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rentnow.dto.RentRecordDto;
import rentnow.model.Rent;
import rentnow.repository.RentRepository;
import rentnow.service.RentService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rents")
public class RentController {

    @Autowired
    private RentService rentService;

    @PostMapping
    public ResponseEntity<Rent> saveRent(@RequestBody @Validated RentRecordDto rentRecordDto) {
        var rent = new Rent();
        BeanUtils.copyProperties(rentRecordDto, rent);
        Rent saveRent = rentService.saveRent(rent);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRent);
    }

    @GetMapping
    public ResponseEntity<List<Rent>> getAllRents() {
    List<Rent> rentList = rentService.getAllRents();
    return ResponseEntity.ok(rentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRentById(@PathVariable(value = "id") UUID uuid) {
        Optional<Rent> rent = rentService.getRentById(uuid);
        if(rent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent not found.");

        }

        return ResponseEntity.ok(rent.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRent(@PathVariable(value = "id") UUID uuid, @RequestBody @Validated RentRecordDto rentRecordDto) {
        Optional<Rent> updateRent = rentService.updateRent(uuid, rentRecordDto);
        if(updateRent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent not found");

        }

        return ResponseEntity.ok(updateRent.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRent(@PathVariable(value = "id") UUID uuid) {
        boolean deleted = rentService.deleteRent(uuid);
        if(!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent not found!");
        }
        return ResponseEntity.ok("Rent deleted succesfully");
    }
    }