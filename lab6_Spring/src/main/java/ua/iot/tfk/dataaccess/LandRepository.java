package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.Land;

@Repository
public interface LandRepository extends JpaRepository<Land, Integer> {
}
