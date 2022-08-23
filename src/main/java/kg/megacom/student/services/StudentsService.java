package kg.megacom.student.services;

import kg.megacom.student.models.Students;
import kg.megacom.student.models.dto.StudentsDto;

public interface StudentsService {

    Students createStudent(StudentsDto students);

    Object updateStudent(Long id, String title);

}
