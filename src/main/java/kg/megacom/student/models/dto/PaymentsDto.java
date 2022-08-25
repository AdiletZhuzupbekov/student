package kg.megacom.student.models.dto;

import kg.megacom.student.models.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsDto {
    Long id;
    GroupsDto groups;
    StudentsDto students;
    Date paymentDate;
    PaymentStatus paymentStatus;
    private double payment;
}
