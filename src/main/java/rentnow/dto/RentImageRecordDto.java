package rentnow.dto;

import rentnow.model.RentImage;

public record RentImageRecordDto(long rentImageId, long rentId, String path) {

    public static RentImageRecordDto fromEntity(RentImage rentImage) {
        return new RentImageRecordDto(
                rentImage.getRentImageId(),
                rentImage.getRentId(),
                rentImage.getPath()
        );
    }

    public RentImage toEntity() {
        RentImage rentImage = new RentImage();
        rentImage.setRentImageId(this.rentImageId);
        rentImage.setPath(this.path);
        rentImage.setRentId(rentId);
        return rentImage;
    }
}   //A classe Record já traz os métodos getters, construtores, to String, hashcode, são imutáveis
    // por isso não possuem os métodos setters, apenas os getters e são privates do tipo final.