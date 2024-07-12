package ru.netology.statistic;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {

    @Test
    public void testAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        List<String> movies = manager.findAll();
        assertEquals(1, movies.size());
        assertEquals("Бладшот", movies.get(0));
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");
        List<String> movies = manager.findAll();
        assertEquals(3, movies.size());
        assertEquals("Бладшот", movies.get(0));
        assertEquals("Вперёд", movies.get(1));
        assertEquals("Отель 'Белград'", movies.get(2));
    }

    @Test
    public void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        List<String> movies = manager.findLast();
        assertEquals(5, movies.size());
        assertEquals("Тролли. Мировой тур", movies.get(0));
        assertEquals("Человек-невидимка", movies.get(1));
        assertEquals("Джентльмены", movies.get(2));
        assertEquals("Отель 'Белград'", movies.get(3));
        assertEquals("Вперёд", movies.get(4));
    }

    @Test
    public void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        List<String> movies = manager.findLast();
        assertEquals(3, movies.size());
        assertEquals("Человек-невидимка", movies.get(0));
        assertEquals("Джентльмены", movies.get(1));
        assertEquals("Отель 'Белград'", movies.get(2));
    }
}

