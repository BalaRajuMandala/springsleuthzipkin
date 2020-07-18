package com.mandala.activitiesperhour.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.mandala.activitiesperhour.entity.ActivityEntity;
import com.mandala.activitiesperhour.entity.Jokes;
import com.mandala.activitiesperhour.entity.Quotes;
import com.mandala.activitiesperhour.repository.ActivityRepository;

import reactor.core.publisher.Mono;

@RestController
public class ActivitiesController {

	private static Logger log = LoggerFactory.getLogger(ActivitiesController.class);

	@Autowired
	ActivityRepository repo;

	@GetMapping("activities")
	private ResponseEntity<List<ActivityEntity>> getActivities() {
		log.info("in ActivitiesController getActivities()");
		List<ActivityEntity> result = (List<ActivityEntity>) repo.findAll();

		return new ResponseEntity<List<ActivityEntity>>(result, HttpStatus.OK);
	}

	@GetMapping("save")
	private ResponseEntity<ActivityEntity> saveActivities() {
		log.info("in ActivitiesController saveActivities()");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String date = formatter.format(new Date());

		formatter = new SimpleDateFormat("HH:mm");
		String hour = formatter.format(new Date());

		ActivityEntity result = repo.save(new ActivityEntity(date, hour, "JPA example practice.", "P"));
		return new ResponseEntity<ActivityEntity>(result, HttpStatus.OK);
	}

	@GetMapping("quote")
	private Mono<Quotes> getQuote() {
		log.info("in ActivitiesController getQuote()");
		return WebClient.builder().baseUrl("https://www.affirmations.dev").build().get().uri("/").retrieve()
				.bodyToMono(Quotes.class);
	}

	@GetMapping("joke")
	private Mono<Jokes> getJoke() {
		log.info("in ActivitiesController getJoke()");
		return WebClient.builder().baseUrl("https://icanhazdadjoke.com")
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).build().get().uri("/").retrieve()
				.bodyToMono(Jokes.class);
	}

//	@GetMapping("restquote")
//	private ResponseEntity<Quotes> getRestQuote() {
//		log.info("in ActivitiesController getRestQuote()");
//		ResponseEntity<Quotes> res = resttemp.getForEntity("https://www.affirmations.dev/", Quotes.class);
//		return res;
//		// return
//		// WebClient.builder().baseUrl("https://www.affirmations.dev").build().get().uri("/").retrieve().bodyToMono(Quotes.class);
//	}
//
//	@GetMapping("restjoke")
//	private ResponseEntity<Jokes> getRestJoke() {
//		log.info("in ActivitiesController getRestJoke()");
//
//		HttpHeaders header = new HttpHeaders();
//		header.set(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE);
//		// header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//		HttpEntity entity = new HttpEntity(null, header);
//		ResponseEntity<Jokes> res = resttemp.exchange("https://icanhazdadjoke.com/", HttpMethod.GET, entity,
//				Jokes.class);
//		return res;
//		// return
//		// WebClient.builder().baseUrl("https://icanhazdadjoke.com").defaultHeader(HttpHeaders.ACCEPT,
//		// MediaType.APPLICATION_JSON_VALUE).build().get().uri("/").retrieve().bodyToMono(Jokes.class);
//	}
}
