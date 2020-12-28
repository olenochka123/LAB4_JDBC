package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
