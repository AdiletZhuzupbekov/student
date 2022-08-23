package kg.megacom.student.models.dto;

import kg.megacom.student.models.enums.StudentStatus;
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
public class StudentGroupDto {

    Long id;
    StudentsDto students;
    GroupsDto groups;
    Date startDate;
    Date endDate;
    StudentStatus studentStatus;
}

