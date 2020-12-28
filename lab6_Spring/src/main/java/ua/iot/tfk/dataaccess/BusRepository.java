package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
}
