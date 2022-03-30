package com.okursan.author;

import com.okursan.author.security.StringEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorApplication.class, args);

		while (true) {
			var asd = StringEncoder.encodeString("Ali Yetkin 44");
			var asd2 = StringEncoder.decodeString(asd);
			var ddd = asd2;
		}
	}

}
