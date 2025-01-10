package rentnow.model;

import jakarta.persistence.*;

@Entity //È o registro do banco de dados no java
@Table(name = "rent_images")
public class RentImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_image_id")
    private long rentImageId;

    @Column(name = "rent_id", nullable = false)
    private long rentId;

    @Column(nullable = false)
    private String path;

    public RentImage() {

    }

    public RentImage(long rentImageId, long rentId, String path) {
        this.rentImageId = rentImageId;
        this.rentId = rentId;
        this.path = path;
    }

    public long getRentImageId() {
        return rentImageId;
    }

    public void setRentImageId(long rentImageId) {
        this.rentImageId = rentImageId;
    }

    public long getRentId() {
        return rentId;
    }

    public void setRentId(long rentId) {
        this.rentId = rentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
