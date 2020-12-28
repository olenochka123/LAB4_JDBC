package ua.iot.tfk.domain;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "land")
public class Land {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "land_name")
    private String landName;

    public Land() { }

    public Land(String landName) {
        this.landName = landName;
    }

    public String getId() {
        return landName;
    }

    public void setId(String landName) {
        this.landName = landName;
    }



    @Override
    public String toString() {
        return "Land{" +
                "landName=" + landName +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Land)) return false;
        Land land = (Land) o;
        return landName.equals(land.landName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(landName);
    }
}
