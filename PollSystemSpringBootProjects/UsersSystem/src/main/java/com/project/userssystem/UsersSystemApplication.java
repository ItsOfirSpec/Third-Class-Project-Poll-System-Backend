package com.project.userssystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//:: הערה ::
//יש למערכת בנוסף גם UI
//אחרי שמריצים את שני הפרוייקטים, להיכנס לכתובת הזאתי
//http://localhost:8081/
//הקובץ html נמצא ב
//:: resources/static/index.html

@SpringBootApplication
@EnableFeignClients
public class UsersSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersSystemApplication.class, args);
	}

}
