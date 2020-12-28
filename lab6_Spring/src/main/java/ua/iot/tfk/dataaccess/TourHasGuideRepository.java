package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.TourHasGuide;

@Repository
public interface TourHasGuideRepository extends JpaRepository<TourHasGuide, Integer> {
}
