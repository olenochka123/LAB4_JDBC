package ua.iot.tfk.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "start_next_arrival")
public class StartNextArrival {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_start_next_arrival")
  private Integer idStartNextArrival;

  @Column(name = "start_next_arrival_date")
  private String startNextArrivalDate;

  @Column(name = "id_tour")
  private Integer idTour;

  public StartNextArrival() { }

  public StartNextArrival(String startNextArrivalDate, Integer idTour) {
    this(-1,startNextArrivalDate,idTour);
  }

  public StartNextArrival(Integer idStartNextArrival, String startNextArrivalDate, Integer idTour) {
    this.idStartNextArrival = idStartNextArrival;
    this.startNextArrivalDate = startNextArrivalDate;
    this.idTour = idTour;
  }

  public Integer getId() {
    return idStartNextArrival;
  }

  public void setId(Integer idStartNextArrival) {
    this.idStartNextArrival = idStartNextArrival;
  }

  public String getStartNextArrivalDate() {
    return startNextArrivalDate;
  }

  public void setStartNextArrivalDate(String startNextArrivalDate) {
    this.startNextArrivalDate = startNextArrivalDate;
  }

  public Integer getIdTour() {
    return idTour;
  }

  public void setIdTour(Integer idTour) {
    this.idTour = idTour;
  }

  @Override
  public String toString() {
    return "StartNextArrival{" +
            "idStartNextArrival=" + idStartNextArrival +
            ", startNextArrivalDate=" + startNextArrivalDate +
            ", idTour=" + idTour +
            '}' + "\n";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof StartNextArrival)) return false;
    StartNextArrival that = (StartNextArrival) o;
    return idStartNextArrival.equals(that.idStartNextArrival) &&
            startNextArrivalDate.equals(that.startNextArrivalDate) &&
            idTour.equals(that.idTour);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idStartNextArrival, startNextArrivalDate, idTour);
  }
}



