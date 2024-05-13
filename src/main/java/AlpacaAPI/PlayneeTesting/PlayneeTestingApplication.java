package AlpacaAPI.PlayneeTesting;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class PlayneeTestingApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlayneeTestingApplication.class, args);
		AlpacaAPISettings tokenAPI = new AlpacaAPISettings();  // Nossas configs
		AlpacaAPIMetodos metodosAPI = new AlpacaAPIMetodos();  // Nossos metodos
		String token = tokenAPI.APITokenCall();

		RestTemplate rt = new RestTemplate(); // É um método do spring para facilitar requisições HTTP. Basicamente, é a parte do código mais importante, que faz
												// Literalmente TUDO funcionar / Conectar-se a GraphAPI.

		String message = "Teste de modularização parte 2 - só texto"; // Messagem que será postada junto da foto. ( ou só o texto, cao seja postText)

		/*
		 String post_url = tokenAPI.MessagePostURlCall();
		 String responseText = metodosAPI.postText(message, token, rt, post_url);
		 System.out.println(responseText);
		*/

		String imagePostURL = tokenAPI.ImagePostURLCall(); // URL do metodo post da META
		String imageURL = "https://cdn.donmai.us/sample/73/0a/__makima_chainsaw_man_drawn_by_58_opal_00_58__sample-730ae0c383b08c6b1db7fdfe56c9917c.jpg"; // Coloque a URL da foto que quer. - tem que ser URL.
		String response = metodosAPI.postImage(message,imageURL,token,rt,imagePostURL);

		System.out.println(response); // Só para poder ver se funcionou ou não- Retorna o ID da postagem, para ser colocado no banco de dados.
	}
}
