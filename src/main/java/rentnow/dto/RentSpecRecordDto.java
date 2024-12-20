package rentnow.dto;

import rentnow.enums.SpecType;

public record RentSpecRecordDto(long rentSpecId, long rentId, SpecType specType, String specvalue) {

}
