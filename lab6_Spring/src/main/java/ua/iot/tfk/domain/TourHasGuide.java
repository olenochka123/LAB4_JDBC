package ua.iot.tfk.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tour_has_guide")
public class TourHasGuide {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "id_tour", referencedColumnName = "id_tour")
    private Tour tour;


    @ManyToOne
    @JoinColumn(name = "id_guide", referencedColumnName = "id_guide")
    private Guide guide;


    public TourHasGuide() {
    }

    public TourHasGuide(Tour tour, Guide guide) {
        this.tour = tour;
        this.guide = guide;
    }


    public TourHasGuide(Integer id, Tour tour, Guide guide) {
        this.id = id;
        this.tour = tour;
        this.guide = guide;
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

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    @Override
    public String toString() {
        return "TourHasGuide{" +
                "id=" + id +
                ", tour=" + tour +
                ", guide=" + guide +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TourHasGuide)) return false;
        TourHasGuide that = (TourHasGuide) o;
        return id.equals(that.id) &&
                tour.equals(that.tour) &&
                guide.equals(that.guide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tour, guide);
    }
}
