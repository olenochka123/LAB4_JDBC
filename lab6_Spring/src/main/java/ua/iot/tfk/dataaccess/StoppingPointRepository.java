package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.StoppingPoint;

@Repository
public interface StoppingPointRepository extends JpaRepository<StoppingPoint, Integer> {
}
