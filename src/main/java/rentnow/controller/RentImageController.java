package rentnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rentnow.model.RentImage;
import rentnow.service.RentImageService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rent-images")
public class RentImageController {

    @Autowired
    private RentImageService rentImageService;

    @PostMapping
    public ResponseEntity<RentImage> saveRentImage(@RequestBody @Validated RentImage rentImage) {
        RentImage savedRentImage = rentImageService.saveRentImage(rentImage);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRentImage);
        //vai salvar o RentImage na sua base de dados!
    }

    @GetMapping
    public ResponseEntity<List<RentImage>> getAllRentImages() {
        List<RentImage> rentImageList = rentImageService.getAllRentImages();
        return ResponseEntity.ok().body(rentImageList);
        //vai ser retornado uma lista especificada como rentImageList!
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRentImagesById(@PathVariable Long id) {
        Optional<RentImage> rentImage = rentImageService.getRentImagesById(id);
        if(rentImage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent Images not found.");
        }
            return ResponseEntity.ok(rentImage.get());
    } //vai salvar o RentImages pelo seu ID

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRentImages(@PathVariable Long id, @RequestBody RentImage rentImage) {
        Optional<RentImage> updateRentImage = rentImageService.updateRentImages(id, rentImage);
        if(updateRentImage.isEmpty()) {
            return ResponseEntity.ok(updateRentImage.get());
        }
        return ResponseEntity.ok(updateRentImage.get()); //vai ser atualizado as imagens pelo id
        // salvo na base de dados como rentImage.
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentImages(@PathVariable Long id) {
        boolean deleted = rentImageService.deleteRentImages(id);
        if(!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rent Images not found.");
        }
            return ResponseEntity.ok("Rent Images not found");
    } //vai deletar o RentImages pelo seu id
}
