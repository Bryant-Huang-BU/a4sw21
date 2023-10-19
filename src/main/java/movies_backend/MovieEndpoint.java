package movies_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;
import java.util.Scanner;
@RestController
public class MovieEndpoint{
    @Autowired
    private MovieService mS;

    @GetMapping(value = "/initialize")
    public List<DTO> initialize() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/movies.csv"));
        sc.nextLine();
        sc.useDelimiter(",");   //sets the delimiter pattern
        String line = "";
        String splitBy = ",";
        String ph1,ph2,ph3,ph4,ph5;
        /*while (sc.hasNext()) {
            if (sc.hasNext()) {
                ph1 = sc.next();
            }
            ph2 = sc.next();
            if (ph2 == null) {
                ph2 = "";
            }
            ph3 = sc.next();
            if (ph3 == null) {
                ph3 = "";
            }
            ph4 = sc.next();
            if (ph4 == null) {
                ph4 = "";
            }
            ph5 = sc.next();
            if (ph5 == null) {
                ph5 = "";
            }
            mS.addMovie(ph1, ph2, ph3, ph4, ph5);
        }*/
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/movies.csv"));
            br.readLine();
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] m= line.split(splitBy, -1);    // use comma as separator
                mS.addMovie(m[1], m[2], m[3], m[4], m[5]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        sc.close();
        return mS.getAll();
    }

    @PostMapping("/add_movie")
    public Movie addMovie(@RequestParam String title, @RequestParam String genre, @RequestParam String year, @RequestParam String score, @RequestParam String studio) {
        return mS.addMovie(title, genre, year, score, studio);
    }

    @PostMapping("update_movie_rating")
    public DTO updateMovieRating (@RequestParam String title, @RequestParam String score) {
        return mS.updateScore(title, score);
    }

    @GetMapping("top_movies")
    public List<Movie> topMovies() {
        return mS.topMovies();
    }


}
