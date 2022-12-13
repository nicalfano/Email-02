package co.develhope.Email1.controllers;

import co.develhope.Email1.entities.Student;
import co.develhope.Email1.servicies.EmailService;
import co.develhope.Email1.entities.NotificationDTO;
import co.develhope.Email1.servicies.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/email")
    public ResponseEntity sendEmail(@RequestBody NotificationDTO payload) {
        try {
            Student studentToSendMail = studentService.getStudentById(payload.getContactId());
            System.out.println("getting the Student" + studentToSendMail);
            if (studentToSendMail == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not find the student");
            }
            emailService.sendTo(payload.getTitle(), payload.getText(), studentToSendMail.getEmail());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            System.out.println("Error in notification controller: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}