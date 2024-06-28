package MovieTicketBookingSystem.service;

import MovieTicketBookingSystem.entity.Movie;
import MovieTicketBookingSystem.Mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieMapper movieMapper;

    // 构造器注入
    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = movieMapper.findAll();
        //movies.forEach(movie -> System.out.println("Movie release date: " + movie.getReleaseDate()));
        return movies;
    }


    public Movie getMovieById(Long id) {
        return movieMapper.findById(id);
    }

    public Movie saveMovie(Movie movie) {
        movieMapper.save(movie);
        return movie;
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = movieMapper.findById(id);
        if (movie != null) {
            movie.setTitle(movieDetails.getTitle());
            movie.setGenre(movieDetails.getGenre());
            movie.setDuration(movieDetails.getDuration());
            movie.setReleaseDate(movieDetails.getReleaseDate());
            movie.setDescription(movieDetails.getDescription());
            movie.setLanguage(movieDetails.getLanguage());
            movie.setRating(movieDetails.getRating());
            movieMapper.update(movie);
            return movie;
        } else {
            return null;
        }
    }

    public boolean deleteMovie(Long id) {
        if (movieMapper.existsById(id)) {
            movieMapper.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
