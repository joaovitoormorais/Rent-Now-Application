package rentnow.model;

import jakarta.persistence.*;
import rentnow.enums.SpecType;

@Entity
@Table(name = "rent_specs")
public class RentSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rentSpecId;

    @ManyToOne
    @JoinColumn(name = "rent_id", nullable = false)
    private Rent rent;

    @Enumerated(EnumType.STRING)
    @Column(name = "spec_type", nullable = false)
    private SpecType specType;

    @Column(name = "spec_value", nullable = false)
    private String specValue;

    public RentSpec() {

    }

    public long getRentSpecId() {
        return rentSpecId;
    }

    public void setRentSpecId(long rentSpecId) {
        this.rentSpecId = rentSpecId;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public SpecType getSpecType() {
        return specType;
    }

    public void setSpecType(SpecType specType) {
        this.specType = specType;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }

    public RentSpec(long rentSpecId, Rent rent, SpecType specType, String specValue) {
        this.rentSpecId = rentSpecId;
        this.rent = rent;
        this.specType = specType;
        this.specValue = specValue;
    }
}
