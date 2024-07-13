package ru.netology.statistic;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    @Test
    public void testAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        String[] movies = manager.findAll().toArray(new String[0]);
        assertArrayEquals(new String[]{"Бладшот"}, movies);
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");
        String[] movies = manager.findAll().toArray(new String[0]);
        assertArrayEquals(new String[]{"Бладшот", "Вперёд", "Отель 'Белград'"}, movies);
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
        String[] movies = manager.findLast().toArray(new String[0]);
        assertArrayEquals(new String[]{
                "Тролли. Мировой тур",
                "Человек-невидимка",
                "Джентльмены",
                "Отель 'Белград'",
                "Вперёд"
        }, movies);
    }

    @Test
    public void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        String[] movies = manager.findLast().toArray(new String[0]);
        assertArrayEquals(new String[]{
                "Человек-невидимка",
                "Джентльмены",
                "Отель 'Белград'"
        }, movies);
    }
}
