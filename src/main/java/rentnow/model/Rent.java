package rentnow.model;
import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rents")
public class Rent extends RepresentationModel<Rent> implements  Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idproduct;

    public UUID getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(UUID idproduct) {
        this.idproduct = idproduct;
    }

    @Column
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
     private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String summary;

    @Column(name = "rent_price", nullable = false)
    private double rentCondominium;

    @Column(name = "rent_condominium", nullable = false)
    private double rentFess;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    public Rent() {

    }

    public Rent(Long id, String description, String summary, double rentCondominium, double rentFess, LocalDateTime createAt, UUID uuid) {
        this.id = id;
        this.description = description;
        this.summary = summary;
        this.rentCondominium = rentCondominium;
        this.rentFess = rentFess;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getRentCondominium() {
        return rentCondominium;
    }

    public void setRentCondominium(double rentCondominium) {
        this.rentCondominium = rentCondominium;
    }

    public double getRentFess() {
        return rentFess;
    }

    public void setRentFess(double rentFess) {
        this.rentFess = rentFess;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}