package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.Pedestrian;

@Repository
public interface PedestrianRepository extends JpaRepository<Pedestrian, Integer> {
}
