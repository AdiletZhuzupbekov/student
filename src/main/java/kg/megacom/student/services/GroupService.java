package kg.megacom.student.services;

import kg.megacom.student.models.Groups;
import kg.megacom.student.models.dto.CourseDto;
import kg.megacom.student.models.requests.GroupRequest;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface GroupService {
    Groups create(GroupRequest groupRequest);
    Groups findById(Long groupId);
}
