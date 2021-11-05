package allanjose.springboot2.client;

import allanjose.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/2", Anime.class);
        log.info(entity);

        Anime ob = new RestTemplate().getForObject("http://localhost:8080/animes/2", Anime.class);
        log.info(ob);
//
//        ResponseEntity<List<Anime>> ex = new RestTemplate().exchange("http://localhost:8080/animes", HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Anime>>() {
//                });
//        log.info(ex.getBody());
//
//
//        Anime novoNome = Anime.builder().name("José Allan").build();
//        Anime novoNomeSalvo = new RestTemplate().postForObject("http://localhost:8080/animes",
//                novoNome, Anime.class);

        Anime novoNome = Anime.builder().name("José Allan").build();
        ResponseEntity<Anime> novoNomeSalvo = new RestTemplate().exchange("http://localhost:8080/animes",
                HttpMethod.POST, new HttpEntity<>(novoNome), Anime.class);


    }
}
