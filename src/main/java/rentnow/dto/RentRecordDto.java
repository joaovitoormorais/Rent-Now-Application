package rentnow.dto;

import java.time.LocalDateTime;

public record RentRecordDto(Long id, String description, String summary,
                            double rentCondominium, double rentFess, LocalDateTime
                            createAt) {

    public RentRecordDto {
        if(rentCondominium < 0 || rentFess < 0) {
            try {
                throw new IllegalAccessException("Values for rentcondominium and rentfess not negative");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

}