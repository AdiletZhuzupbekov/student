package kg.megacom.student.services;

import kg.megacom.student.models.enums.PaymentStatus;

import java.util.Date;

public interface PaymentService {

    Object payment(Date paymentDate, Long groupId, Long studentId, double payment);
}
