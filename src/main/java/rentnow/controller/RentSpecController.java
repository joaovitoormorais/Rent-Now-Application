package rentnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rentnow.model.RentSpec;
import rentnow.service.RentSpecService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rent-specs")
public class RentSpecController {

    @Autowired
    private RentSpecService rentSpecService;

    @PostMapping
    public ResponseEntity<RentSpec> saveRentSpec(@RequestBody @Validated RentSpec rentSpec) {
        RentSpec savedRentSpec  = rentSpecService.saveRentSpec(rentSpec);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRentSpec);
    }  //vai salvar o RentSpec na sua base de dados!

    @GetMapping
    public ResponseEntity<List<RentSpec>> getAllRentSpec() {
        List<RentSpec> rentSpecList = rentSpecService.getAllRentSpec();
        return ResponseEntity.ok().body(rentSpecList);
    } //vai retornar uma lista especificada como rentImageSpec!

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRentSpecById(@PathVariable Long rentSpecId) {
        Optional<RentSpec> rentSpec = rentSpecService.getRentSpecById(rentSpecId);
        if(rentSpec.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent Spec not found.");
        }
            return ResponseEntity.ok(rentSpec.get());
    } //vai salvar o rent spec pelo seu id.

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRentSpec(@PathVariable Long rentSpecId, @RequestBody RentSpec rentSpec) {
        Optional<RentSpec> updateRentSpec = rentSpecService.updateRentSpec(rentSpecId, rentSpec);
        if(updateRentSpec.isEmpty()) {
           return ResponseEntity.ok(updateRentSpec.get());
        }
        return ResponseEntity.ok(updateRentSpec.get());
    } //vai atualizar o RentSpec pelo id dele.

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentSpec(@PathVariable Long rentSpecId) {
        boolean deleted = rentSpecService.deleteRentSpec(rentSpecId);
        if(!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent Spec not found");
        }
            return ResponseEntity.ok("Rent Spec not found");
    } //o rent spec  vai ser deletado pelo seu id.
}
