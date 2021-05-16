package com.vexere.server;

import com.vexere.server.repos.TripRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages={"com.vexere.server.controllers","com.vexere.server.repos"})
//@EnableJpaRepositories("com.vexere.server.repos")
public class ServerApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ServerApplication.class, args);

		TripRepository triprepos = context.getBean(TripRepository.class);
//		triprepos.findAll().toArray();

		System.out.println(triprepos.findAll().toArray());
	}

//	@Bean
//	public TripRepoImpl tripRepoImpl() {
//		return new TripRepoImpl ();
//	}
}
