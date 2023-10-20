package movies_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository mR;

    public Movie addMovie(String title, String genres, int movieYear, int rottenTomatoesScore, String leadStudio) {
        Movie m = new Movie(title, genres, movieYear, rottenTomatoesScore, leadStudio);
        return mR.save(m);
    }
    public List<DTO> getAll() {
        List<Movie> m = mR.findAll();
        List<DTO> d = new ArrayList<>();
        for (int i = 0; i < m.size(); i++) {
            d.add(new DTO(m.get(i)));
        }
        return d;
    }

    public DTSearch updateScore(String title, int score) {
        Movie m = mR.findFirstByTitle(title);
        m.setRottenTomatoesScore(score);
        DTSearch d =  new DTSearch (m);
        return d;
    }

    public List<DTO> topMovies() {
        List<Movie> m = mR.findTop20ByOrderByMovieYearDesc();
        List<DTO> d = new ArrayList<>();
        for (int i = 0; i < m.size(); i++) {
            d.add(new DTO(m.get(i)));
        }
        return d;
    }

    public List<DTO> findByTitle(String title) {
        List<Movie> m = mR.findByTitleContainingOrderByMovieYearDesc(title);
        List<DTO> d = new ArrayList<>();
        for (int i = 0; i < m.size(); i++) {
            d.add(new DTO(m.get(i)));
        }
        return d;
    }
}
