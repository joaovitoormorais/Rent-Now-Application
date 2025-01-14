package rentnow.dto;

import rentnow.enums.SpecType;
import rentnow.model.Rent;
import rentnow.model.RentSpec;

public record RentSpecRecordDto(Long rentSpecId, Long rentId, SpecType specType, String specvalue) {

    public static RentSpecRecordDto fromEntity(RentSpec rentSpec) {
        return new RentSpecRecordDto(
              rentSpec.getRentSpecId(),
              rentSpec.getRent().getId(),
              rentSpec.getSpecType(),
              rentSpec.getSpecValue()

        );

    }

    public RentSpec toEntity(Rent rent) {
        RentSpec rentSpec = new RentSpec();
        rentSpec.setRent(rent);
        rentSpec.setSpecType(this.specType);
        rentSpec.setRentSpecId(this.rentSpecId);
        rentSpec.setSpecValue(this.specvalue);
        return rentSpec;
    }
}    //A classe Record já traz os métodos getters, construtores, to String, hashcode, são imutáveis
    // por isso não possuem os métodos setters, apenas os getters e são privates do tipo final.