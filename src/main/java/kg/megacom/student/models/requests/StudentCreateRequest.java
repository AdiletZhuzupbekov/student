package kg.megacom.student.models.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentCreateRequest {
    private String name;
    private String sureName;
    private String title;
    private Long groupId;
}
