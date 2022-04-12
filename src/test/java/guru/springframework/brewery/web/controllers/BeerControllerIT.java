package guru.springframework.brewery.web.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import guru.springframework.brewery.web.model.BeerPagedList;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BeerControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testListBeers() {
		BeerPagedList beerPagedList = restTemplate.getForObject("/api/v1/beer", BeerPagedList.class);
		
		assertThat(beerPagedList.getContent()).hasSize(3);
	}
	
}
