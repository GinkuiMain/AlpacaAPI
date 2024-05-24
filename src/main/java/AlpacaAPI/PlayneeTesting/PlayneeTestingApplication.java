package AlpacaAPI.PlayneeTesting;

import AlpacaAPI.PlayneeTesting.services.PostService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PlayneeTestingApplication implements CommandLineRunner {

	@Autowired
	private PostService postService;

	public static void main(String[] args) {
		SpringApplication.run(PlayneeTestingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AlpacaAPISettings tokenAPI = new AlpacaAPISettings();
		AlpacaAPIMetodos metodosAPI = new AlpacaAPIMetodos();
		String token = tokenAPI.APITokenCall();

		RestTemplate rt = new RestTemplate();

		String message = "{ Testando Postagem - Squad 14 | Vamos de Sabaton. 2 }";

		String imagePostURL = tokenAPI.ImagePostURLCall();
		String imageURL = "https://i.ytimg.com/vi/7lb-0h8TWaU/hqdefault.jpg?sqp=-oaymwEbCKgBEF5IVfKriqkDDggBFQAAiEIYAXABwAEG&rs=AOn4CLBziLZ6W31rD4hhnTENWYJU2cNRGg";
		String response = metodosAPI.postImage(message, imageURL, token, rt, imagePostURL);

		System.out.println("Response: " + response);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode responseJson = mapper.readTree(response);

		if (responseJson.has("id") && responseJson.has("post_id")) {
			String postId = responseJson.get("id").asText(); // Converte id para String
			String post_id = responseJson.get("post_id").asText();

			postService.savePost(postId, post_id); // Chama o método savePost com Strings
		} else {
			System.out.println("A resposta JSON não contém os campos esperados: id e post_id");
		}
	}
}

// Zuzu está cansado.