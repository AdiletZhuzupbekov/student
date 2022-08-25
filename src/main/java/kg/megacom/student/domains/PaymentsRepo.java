package kg.megacom.student.domains;

import kg.megacom.student.models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepo extends JpaRepository<Payments, Long> {
    double findPaymentsByStudentsId(Long studentId);
}
