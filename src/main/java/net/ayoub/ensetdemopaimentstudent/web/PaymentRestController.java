package net.ayoub.ensetdemopaimentstudent.web;

import net.ayoub.ensetdemopaimentstudent.entities.Payment;
import net.ayoub.ensetdemopaimentstudent.entities.PaymentStatus;
import net.ayoub.ensetdemopaimentstudent.entities.PaymentType;
import net.ayoub.ensetdemopaimentstudent.entities.Student;
import net.ayoub.ensetdemopaimentstudent.repository.PaymentRepository;
import net.ayoub.ensetdemopaimentstudent.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentRestController {

    private PaymentRepository paymentRepository;
    private StudentRepository studentRepository;

    public PaymentRestController(PaymentRepository paymentRepository, StudentRepository studentRepository) {
        this.paymentRepository = paymentRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping(path = "/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }

    @GetMapping(path = "/students/{code}/payments")
    public List<Payment> paymentsByCode(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping(path = "/payments/byStatus")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }

    @GetMapping(path = "/payments/byType")
    public List<Payment> paymentsByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }

    @GetMapping("/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{code}")
    public Student getStudentByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
    }

    @GetMapping("/studentsByProgramId")
    public List<Student> getStudentsByProgramId(@RequestParam String programId){
        return studentRepository.findByProgramId(programId);
    }
}
