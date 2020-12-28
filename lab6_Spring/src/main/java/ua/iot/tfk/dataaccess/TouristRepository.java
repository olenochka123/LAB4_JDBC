package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.Tourist;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Integer> {
}
