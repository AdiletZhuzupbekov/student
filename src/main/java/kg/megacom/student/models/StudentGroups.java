package kg.megacom.student.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss.SSS", locale = "en_GB")
    private Date startDate;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss.SSS", locale = "en_GB")
    private Date endDate;
    @Enumerated(value = EnumType.STRING)
    private StudentStatus studentStatus;
}
