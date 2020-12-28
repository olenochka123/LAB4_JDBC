package ua.iot.tfk.domain;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "tour_has_stopping_point")
public class TourHasStoppingPoint {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tour", referencedColumnName = "id_tour")
    private Tour tour;


    @ManyToOne
    @JoinColumn(name = "id_stopping_point", referencedColumnName = "id_stopping_point")
    private StoppingPoint stoppingPoint;


    public TourHasStoppingPoint(){}

    public TourHasStoppingPoint(Integer id, Tour tour, StoppingPoint stoppingPoint) {
        this.id = id;
        this.tour = tour;
        this.stoppingPoint = stoppingPoint;
    }

    public TourHasStoppingPoint(Tour tour, StoppingPoint stoppingPoint) {
        this.tour = tour;
        this.stoppingPoint = stoppingPoint;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public StoppingPoint getStoppingPoint() {
        return stoppingPoint;
    }

    public void setStoppingPoint(StoppingPoint stoppingPoint) {
        this.stoppingPoint = stoppingPoint;
    }

    @Override
    public String toString() {
        return "TourHasStoppingPoint{" +
                "id=" + id +
                ", tour=" + tour +
                ", stoppingPoint=" + stoppingPoint +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TourHasStoppingPoint)) return false;
        TourHasStoppingPoint that = (TourHasStoppingPoint) o;
        return id.equals(that.id) &&
                tour.equals(that.tour) &&
                stoppingPoint.equals(that.stoppingPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tour, stoppingPoint);
    }
}
