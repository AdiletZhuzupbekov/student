package kg.megacom.student.services;

import kg.megacom.student.models.Students;
import kg.megacom.student.models.dto.StudentsDto;
import kg.megacom.student.models.requests.StudentCreateRequest;

import java.util.List;

public interface StudentsService {

    Students createStudent(StudentCreateRequest StudentCreateRequest);

    Object updateStudent(Long id, String title);

    List<Students> listOfStudents();

    Students findById(Long studentId);
}
