package allanjose.springboot2.service;

import allanjose.springboot2.domain.Anime;
import allanjose.springboot2.repositoy.AnimeRepository;
import allanjose.springboot2.requests.AnimePostRequestBody;
import allanjose.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    // private static List<Anime> animes;

    // static{
    //     animes = new ArrayList<>(List.of((new Anime(1L,"José Allan")),new Anime(2L,"Mariane"),new Anime(3L,"Isaac")));
    // }
    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));

    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
        // anime.setId(ThreadLocalRandom.current().nextLong(4,10000));
        //animes.add(anime);
        return animeRepository.save(anime);
    }

    public void delete(long id) {

        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(animePutRequestBody.getId())
                .name(animePutRequestBody
                        .getName()).build();
        animeRepository.save(anime);
    }
}
