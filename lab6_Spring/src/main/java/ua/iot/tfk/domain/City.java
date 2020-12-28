package ua.iot.tfk.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city")
    private Integer idCity;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "land_name")
    private String landName;

    public City() {
    }

    public City(String cityName,String landName){
        this(-1, cityName,landName);
    }

    public City(Integer idCity, String cityName,String landName) {
        this.idCity = idCity;
        this.cityName = cityName;
        this.landName = landName;
    }

    public Integer getId() {
        return idCity;
    }

    public void setId(Integer idCity) {
        this.idCity = idCity;
    }

    public String getBusName() {
        return cityName;
    }

    public void setBusName(String cityName) {
        this.cityName = cityName;
    }

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }



    @Override
    public String toString() {
        return "Bus{" +
                "id=" + idCity +
                ", cityName='" + cityName  +
                ", landName='" + landName + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return idCity.equals(city.idCity) &&
                cityName.equals(city.cityName) &&
                landName.equals(city.landName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, cityName, landName);
    }
}
