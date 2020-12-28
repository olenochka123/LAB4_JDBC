package ua.iot.tfk.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.tfk.domain.Guide;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Integer> {
}
