package allanjose.springboot2.util;

import allanjose.springboot2.domain.Anime;

public class AnimeCreator {

    public static Anime createAnime(){
        return Anime.builder().name("Isaac Santana da Silva Andrade").build();
    }

    public static Anime createAnimeId(){
        return  Anime.builder().name("Isaac Santana da Silva Andrade").id(1L).build();
    }

    public static Anime updateAnime(){
        return Anime.builder().name("Isaque Santana da Silva Andrade").id(1L).build();
    }
}
