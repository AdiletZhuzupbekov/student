package kg.megacom.student.domains;

import kg.megacom.student.models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, Long> {
    Courses findCoursesById(Long groupId);
}
