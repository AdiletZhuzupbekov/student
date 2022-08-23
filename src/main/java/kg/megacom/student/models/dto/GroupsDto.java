package kg.megacom.student.models.dto;

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
public class GroupsDto {

    Long id;
    String name;
    Date startDate;
    Date endDate;
    CourseDto courses;
    TeacherDto teachers;

}

