package kg.megacom.student.controllers;

import kg.megacom.student.models.dto.GroupsDto;
import kg.megacom.student.services.GroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/v1")

public class GroupsController {
    private final GroupService groupService;

    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/add-group")
    public Object addGroup(@RequestBody GroupsDto groupsDto){
        return groupService.toEntity(groupsDto);
    }
}
