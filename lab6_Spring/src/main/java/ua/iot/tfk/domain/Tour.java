package ua.iot.tfk.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tour")
    private Integer idTour;

    @Column(name = "tour_name")
    private String tourName;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "price_one_person")
    private Integer priceOnePerson;

    @Column(name = "id_pedestrian")
    private Integer idPedestrian;

    @Column(name = "id_bus")
    private Integer idBus;


    @Column(name = "id_cruise")
    private Integer idCruise;



    public Tour() { }

    public Tour( String tourName, String description, Integer duration,
                Integer priceOnePerson, Integer idPedestrian, Integer idBus, Integer idCruise) {
        this(-1,tourName,description,duration,priceOnePerson,idPedestrian,idBus,idCruise);
    }

    public Tour(Integer idTour, String tourName, String description, Integer duration,
                Integer priceOnePerson, Integer idPedestrian, Integer idBus, Integer idCruise) {
        this.idTour = idTour;
        this.tourName = tourName;
        this.description = description;
        this.duration = duration;
        this.priceOnePerson = priceOnePerson;
        this.idPedestrian = idPedestrian;
        this.idBus = idBus;
        this.idCruise = idCruise;
    }

    public Integer getId() {
        return idTour;
    }

    public void setId(Integer idTour) {
        this.idTour = idTour;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPriceOnePerson() {
        return priceOnePerson;
    }

    public void setPriceOnePerson(Integer priceOnePerson) {
        this.priceOnePerson = priceOnePerson;
    }

    public Integer getIdPedestrian() {
        return idPedestrian;
    }

    public void setIdPedestrian(Integer idPedestrian) {
        this.idPedestrian = idPedestrian;
    }

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public Integer getIdCruise() {
        return idCruise;
    }

    public void setIdCruise(Integer idCruise) {
        this.idCruise = idCruise;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + idTour +
                ", tourName='" + tourName + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", priceOnePerson=" + priceOnePerson +
                ", idPedestrian=" + idPedestrian +
                ", idBus=" + idBus +
                ", idCruise=" + idCruise +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return idTour.equals(tour.idTour) &&
                tourName.equals(tour.tourName) &&
                description.equals(tour.description) &&
                duration.equals(tour.duration) &&
                priceOnePerson.equals(tour.priceOnePerson) &&
                idPedestrian.equals(tour.idPedestrian) &&
                idBus.equals(tour.idBus) &&
                idCruise.equals(tour.idCruise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTour, tourName, description, duration, priceOnePerson, idPedestrian, idBus, idCruise);
    }
}
