package com.sv;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		/*
		 * LocalDateTime now = LocalDateTime.now(); System.out.println(now);
		 * LocalDateTime before =LocalDateTime.of(2022, 06, 22, 1, 45);
		 * System.out.println(now.toLocalDate().equals(before.toLocalDate()));
		 */
		System.out.println(new BCryptPasswordEncoder().encode("abc@123"));
	}
}
