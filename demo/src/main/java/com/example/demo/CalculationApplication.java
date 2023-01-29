package com.example.demo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class CalculationApplication {

	public static void main(String[] args) throws IOException {
		System.out.println("Application started!!!");
		SpringApplication.run(CalculationApplication.class, args);
		FileInputStream serviceAccount =
				new FileInputStream("src/credential/firestore.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		FirebaseApp.initializeApp(options);

		System.out.println("Completed to connect to firebase!!!");
	}

}
