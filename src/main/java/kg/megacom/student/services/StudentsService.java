package kg.megacom.student.services;

import kg.megacom.student.models.Students;
import kg.megacom.student.models.dto.StudentsDto;

import java.util.List;

public interface StudentsService {

    Students createStudent(StudentsDto students);

    Object updateStudent(Long id, String title);

    Students deleteStudent(Long id);

    List<Students> findNotDeleted();

    List<Students> listOfStudents();
}
