package ua.iot.tfk.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Integer idHotel;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "pay_on_day")
    private Integer payOnDay;


    @Column(name = "class")
    private Integer hotelClass;

    @Column(name = "id_city")
    private Integer idCity;

    public Hotel() { }

    public Hotel(String hotelName, Integer payOnDay,Integer hotelClass, Integer idCity){
        this(-1, hotelName,payOnDay,hotelClass,idCity);
    }

    public Hotel(Integer idHotel, String hotelName, Integer payOnDay,Integer hotelClass, Integer idCity) {
        this.idHotel = idHotel;
        this.hotelName = hotelName;
        this.payOnDay = payOnDay;
        this.hotelClass = hotelClass;
        this.idCity = idCity;
    }

    public Integer getId() {
        return idHotel;
    }

    public void setId(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getPayOnDay() {
        return payOnDay;
    }

    public void setPayOnDay(Integer payOnDay) {
        this.payOnDay = payOnDay;
    }

    public Integer getHotelClass() {
        return hotelClass;
    }

    public void setHotelClass(Integer hotelClass) {
        this.hotelClass = hotelClass;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + idHotel +
                ", hotelName='" + hotelName + '\'' +
                ", payOnDay=" + payOnDay +
                ", hotelClass=" + hotelClass +
                ", idCity=" + idCity +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return idHotel.equals(hotel.idHotel) &&
                hotelName.equals(hotel.hotelName) &&
                payOnDay.equals(hotel.payOnDay) &&
                hotelClass.equals(hotel.hotelClass) &&
                idCity.equals(hotel.idCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, hotelName, payOnDay, hotelClass, idCity);
    }
}
