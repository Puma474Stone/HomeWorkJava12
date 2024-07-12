package ru.netology.statistic;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<String> movies = new ArrayList<>();
    private int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(String movie) {
        movies.add(movie);
    }

    public List<String> findAll() {
        return new ArrayList<>(movies);
    }

    public List<String> findLast() {
        int resultLength = Math.min(movies.size(), limit);
        List<String> result = new ArrayList<>(resultLength);
        for (int i = 0; i < resultLength; i++) {
            result.add(movies.get(movies.size() - 1 - i));
        }
        return result;
    }
}

