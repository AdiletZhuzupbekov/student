package kg.megacom.student.models;

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
    private Date paymentDate;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;
}
