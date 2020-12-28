package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.TouristDestination;

@Repository
public interface TouristDestinationRepository extends JpaRepository<TouristDestination, Integer> {
}
