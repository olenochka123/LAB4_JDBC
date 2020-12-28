package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.Cruise;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Integer> {
}
