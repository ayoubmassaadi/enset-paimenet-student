package net.ayoub.ensetdemopaimentstudent.repository;

import net.ayoub.ensetdemopaimentstudent.entities.Payment;
import net.ayoub.ensetdemopaimentstudent.entities.PaymentStatus;
import net.ayoub.ensetdemopaimentstudent.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
