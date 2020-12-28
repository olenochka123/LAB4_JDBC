package ua.iot.tfk.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cruise")
public class Cruise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cruise")
    private Integer idCruise;

    @Column(name = "cruise_liner_name")
    private String cruiseLinerName;

    public Cruise() {
    }

    public Cruise(String cruiseLinerName){
        this(-1, cruiseLinerName);
    }

    public Cruise(Integer idCruise, String cruiseLinerName) {
        this.idCruise = idCruise;
        this.cruiseLinerName = cruiseLinerName;
    }

    public Integer getId() {
        return idCruise;
    }

    public void setId(Integer idCruise) {
        this.idCruise = idCruise;
    }

    public String getCruiseLinerName() {
        return cruiseLinerName;
    }

    public void setCruiseLinerName(String cruiseLinerName) {
        this.cruiseLinerName = cruiseLinerName;
    }


    @Override
    public String toString() {
        return "Cruise{" +
                "id=" + idCruise +
                ", cruiseLinerName='" + cruiseLinerName + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cruise)) return false;
        Cruise cruise = (Cruise) o;
        return idCruise.equals(cruise.idCruise) &&
                cruiseLinerName.equals(cruise.cruiseLinerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCruise, cruiseLinerName);
    }
}
