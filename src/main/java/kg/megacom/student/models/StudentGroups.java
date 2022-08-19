package kg.megacom.student.models;

import kg.megacom.student.models.enums.StudentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "student_groups")
public class StudentGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_students")
    private Students students;
    @ManyToOne
    @JoinColumn(name = "id_groups")
    private Groups groups;
    private Date startDate;
    private Date endDate;
    @Enumerated(value = EnumType.STRING)
    private StudentStatus studentStatus;
}
