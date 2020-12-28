package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.StartNextArrival;

@Repository
public interface StartNextArrivalRepository extends JpaRepository<StartNextArrival, Integer> {
}
