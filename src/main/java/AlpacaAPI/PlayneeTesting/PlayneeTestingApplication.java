package AlpacaAPI.PlayneeTesting;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class PlayneeTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayneeTestingApplication.class, args);
		TokenAlpacaAPI tokenAPI = new TokenAlpacaAPI();
		String token = tokenAPI.APIcall(); // Coloque o token de acesso aqui. De preferência, usando um Venv, para manter o token seguro.

		RestTemplate rt = new RestTemplate();

		String message = "Alpaca testing via IntelliJ"; // Messagem que será postada junto da foto. ( ou só o texto, cao seja postText)

		String post_url = "https://graph.facebook.com/v19.0/281266601744759/feed";

		//String response = postText(message, token, rt, url);
		//System.out.println(response);

		String imagePostURL = "https://graph.facebook.com/v19.0/281266601744759/photos"; // URL do metodo post da META

		String imageURL = "https://i.pinimg.com/736x/91/ae/22/91ae22951ab3e7bda89e0fd63c072eba.jpg"; // Coloque a URL da foto que quer.

		String res = postImage(message,imageURL, token, rt, imagePostURL);
		System.out.println(res);
	}


	private static String postImage(String message,String imageURL, String token, RestTemplate rt, String imagePostURL) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String json = "{\n" +
				"			\"\"message\":\"Alpaca Test - Rei Chikita\","+
				"           \"url\":\"" + imageURL + "\",\n" +
				"           \"access_token\":\""+ token +"\"\n" +
				"         }";

		HttpEntity<String> request = new HttpEntity<>(json,headers);

		return rt.postForObject(imagePostURL, request, String.class);
	}

	private static String postText(String message, String token, RestTemplate rt, String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String json = "{\n" +
				"           \"message\":\"" + message + "\",\n" +
				"           \"access_token\":\""+ token +"\"\n" +
				"         }";

		HttpEntity<String> request = new HttpEntity<>(json,headers);

		return rt.postForObject(url, request, String.class);
	}

}
