package allanjose.springboot2.repositoy;

import allanjose.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DisplayName("Test for Anime Repository")
@Log4j2
class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    void save_PersistAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(animeSaved.getName());

    }

    @Test
    void save_UpdatesAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);

        animeSaved.setName("Maria Eduarda");

        Anime animeUpdate = this.animeRepository.save(animeSaved);

        log.info(animeUpdate.getName());

        Assertions.assertThat(animeUpdate).isNotNull();
        Assertions.assertThat(animeUpdate.getId()).isNotNull();
        Assertions.assertThat(animeUpdate.getName()).isEqualTo(animeSaved.getName());

    }

    @Test
    void delete_RemoveAnime(){

        Anime animeToBeSaved = createAnime();
        Anime saved = this.animeRepository.save(animeToBeSaved);

        this.animeRepository.delete(saved);

        Optional<Anime> animeOptional = this.animeRepository.findById(saved.getId());

        Assertions.assertThat(animeOptional.isEmpty());



    }

    private Anime createAnime(){
        return Anime.builder().name("Isaac").build();
    }

}