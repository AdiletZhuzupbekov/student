package kg.megacom.student.services;

import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface StudentGroupService {
    ResponseEntity create(Date startDate, Date endDate, Long studentId, Long groupId);
}
