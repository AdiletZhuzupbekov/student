package kg.megacom.student.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.student.models.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_groups")
    private Groups groups;
    @ManyToOne
    @JoinColumn(name = "id_students")
    private Students students;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss.SSS", locale = "en_GB")
    private Date paymentDate;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;
    private double payment;
}
