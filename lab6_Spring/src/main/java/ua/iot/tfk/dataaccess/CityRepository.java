package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
