package net.ayoub.ensetdemopaimentstudent;

import net.ayoub.ensetdemopaimentstudent.entities.Payment;
import net.ayoub.ensetdemopaimentstudent.entities.PaymentStatus;
import net.ayoub.ensetdemopaimentstudent.entities.PaymentType;
import net.ayoub.ensetdemopaimentstudent.entities.Student;
import net.ayoub.ensetdemopaimentstudent.repository.PaymentRepository;
import net.ayoub.ensetdemopaimentstudent.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class EnsetDemoPaimentStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnsetDemoPaimentStudentApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository,
										PaymentRepository paymentRepository){
		return args -> {
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
					.firstName("Mohammed").code("112233").programId("SDIA")
					.build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
					.firstName("Imane").code("112244").programId("SDIA")
					.build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
					.firstName("Yasmine").code("112255").programId("GLSID")
					.build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
					.firstName("Najat").code("112266").programId("BDCC")
					.build());

			PaymentType[] paymentType = PaymentType.values();
			Random random = new Random();
			studentRepository.findAll().forEach(std -> {
				for (int i = 0; i < 10; i++) {
					int index = random.nextInt(paymentType.length);
					Payment payment = Payment.builder()
							.amount(1000+(int)(Math.random())+20000)
							.type(paymentType[index])
							.status(PaymentStatus.CREATED)
							.date(LocalDate.now())
							.student(std)
							.build();
					paymentRepository.save(payment);
				}
			});
		};
	}

}
