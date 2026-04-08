package com.training;

import com.training.controller.Payment;
import com.training.impl.emailService;
import com.training.impl.smsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot01Application  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Application.class, args);
	}

//	@Autowired
//	private Payment paymentService;
//
//	public SpringBoot01Application(Payment paymentService) {
//		System.out.println("Constructor Injection");
//		this.paymentService = paymentService;
//	}

	public SpringBoot01Application( NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	private NotificationService notificationService ;

	@Override
	public void run(String... args) throws Exception {
//		String pay = paymentService.pay();
//		System.out.println(pay);


//		NotificationService notificationService = new emailService();
		notificationService.send();
	}
}
