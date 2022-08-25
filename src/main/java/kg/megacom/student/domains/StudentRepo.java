package kg.megacom.student.domains;

import kg.megacom.student.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepo extends JpaRepository<Students,Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update students set title = ?2 where id = ?1", nativeQuery = true)
    void update(@Param("id") Long id, @Param("title") String title);

}
