package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.TourHasStoppingPoint;

@Repository
public interface TourHasStoppingPointRepository extends JpaRepository<TourHasStoppingPoint, Integer> {
}
