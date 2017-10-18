package co.edu.ufps.condominio.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder bCrypt= new BCryptPasswordEncoder();
		System.out.println(bCrypt.encode("18711871"));

	}

}
