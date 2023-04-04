package fr.brehierwilliam.cefim;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CefimApplicationTests {

	@Autowired // = singleton
	private MockMvc mockMvc;

	@Autowired
	private EntityManager entityManager;
	private Logger logger = LoggerFactory.getLogger(CefimApplicationTests.class);


	@Test
	void contextLoads() {
	}

	@Test
	void testHelloWorld() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/hello/world").contentType(MediaType.TEXT_PLAIN_VALUE);
		mockMvc.perform(requestBuilder)
				.andExpect(
						status().isOk()
				).andExpect(
						content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE)
				).andExpect(
						content().string("Hello World !")
				);
	}

	@Test
	void testDatabase(){
		Query query = entityManager.createNativeQuery("show tables;");
		List<String> results = ((List<String>) query.getResultList());
		String resultList = String.join(" - ", results);
		logger.info("Connexion à la BDD :: SUCCESS");
		logger.info("Table list of databases = [{}]", resultList);
	}


}
