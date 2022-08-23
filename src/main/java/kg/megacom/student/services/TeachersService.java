package kg.megacom.student.services;

import kg.megacom.student.models.Teachers;
import kg.megacom.student.models.dto.TeacherDto;

public interface TeachersService {
    Teachers addTeacher(TeacherDto teacherDto);

    void deleteTeacher(TeacherDto teacherDto);

    Object listTeacher();
}
