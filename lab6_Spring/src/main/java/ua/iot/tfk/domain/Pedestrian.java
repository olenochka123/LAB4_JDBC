package ua.iot.tfk.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pedestrian")
public class Pedestrian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedestrian")
    private Integer idPedestrian;

    @Column(name = "distance_KM")
    private Integer distanceKM;

    public Pedestrian() {
    }

    public Pedestrian(Integer distanceKM){
        this(-1, distanceKM);
    }

    public Pedestrian(Integer idPedestrian, Integer distanceKM) {
        this.idPedestrian = idPedestrian;
        this.distanceKM = distanceKM;
    }

    public Integer getId() {
        return idPedestrian;
    }

    public void setId(Integer id) {
        this.idPedestrian = idPedestrian;
    }

    public Integer getDistanceKM() {
        return distanceKM;
    }

    public void setDistanceKM(Integer distanceKM) {
        this.distanceKM = distanceKM;
    }


    @Override
    public String toString() {
        return "Pedestrian{" +
                "id=" + idPedestrian +
                ", distanceKM='" + distanceKM + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedestrian)) return false;
        Pedestrian that = (Pedestrian) o;
        return idPedestrian.equals(that.idPedestrian) &&
                distanceKM.equals(that.distanceKM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedestrian, distanceKM);
    }
}
