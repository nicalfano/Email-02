package co.develhope.Email1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Student {
    private String id;
    private String name;
    private String surname;
    private String email;
}
