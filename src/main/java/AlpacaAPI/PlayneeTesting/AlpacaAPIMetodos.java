package AlpacaAPI.PlayneeTesting;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class AlpacaAPIMetodos {
    public String postImage(String message, String imageURL, String token, RestTemplate rt, String imagePostURL) {
        HttpHeaders headers = new HttpHeaders(); // Configura os headers da requisição HTTP. Basicamente, os tipos de dados (abaixo) que serão enviados.
        headers.setContentType(MediaType.APPLICATION_JSON); // Configura o tipo da nossa requisição para JSON
        String json = "{\n" +
                "			\"message\":\"" + message + "\",\n"+
                "           \"url\":\"" + imageURL + "\",\n" +
                "           \"access_token\":\""+ token +"\"\n" +
                "         }";

        HttpEntity<String> request = new HttpEntity<>(json,headers); // Gera nosso JSON + Respectivo Header

        return rt.postForObject(imagePostURL, request, String.class);  // Retorna / Envia os dados - E caso positivo, vai mostrar o ID da postagem no sout alí em cima.
    }
    /*
    public String postText(String message, String token, RestTemplate rt, String url) {  // Segue a mesma lógica do anterior, só que sem a imagem.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String json = "{\n" +
                "           \"message\":\"" + message + "\",\n" +
                "           \"access_token\":\""+ token +"\"\n" +
                "         }";

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        return rt.postForObject(url, request, String.class);
    }
     */
}
