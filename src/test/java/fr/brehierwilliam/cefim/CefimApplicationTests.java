package fr.brehierwilliam.cefim;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CefimApplicationTests {

	@Autowired // = singleton
	private MockMvc mockMvc;


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


}
