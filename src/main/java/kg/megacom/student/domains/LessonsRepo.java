package kg.megacom.student.domains;

import kg.megacom.student.models.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LessonsRepo extends JpaRepository<Lessons, Long> {

    List<Lessons> findAllByGroups_Id(Long id);
}
