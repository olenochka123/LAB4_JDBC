package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
}
