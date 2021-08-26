package com.example.movies;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.ResponseActions;

import com.example.movies.service.MovieService;

@RestClientTest(MovieService.class)
class MoviesApplicationTests {

	@Autowired
	private MovieService movieService;

	@Autowired
	private MockRestServiceServer mockRestServiceServer;
	
	

	@Test
      void userClientSuccessfullyReturnsMovie() {
    	  String json = """
    		   {
                "Title": "Joker",
               "Year": "2019",
               "Rated": "R",
               "Released": "04 Oct 2019",
               "Runtime": "122 min",
               "Genre": "Crime, Drama, Thriller",
               "Director": "Todd Phillips",
               "Writer": "Todd Phillips, Scott Silver, Bob Kane",
               "Actors": "Joaquin Phoenix, Robert De Niro, Zazie Beetz",
               "Plot": "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
               "Language": "English",
               "Country": "United States, Canada",
               "Awards": "Won 2 Oscars. 118 wins & 239 nominations total",
               "Poster": "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg",
               "Ratings": [
                  {
                   "Source": "Internet Movie Database",
                   "Value": "8.4/10"
                  },
                  {
                   "Source": "Rotten Tomatoes",
                   "Value": "68%"
                  },
                  {
                   "Source": "Metacritic",
                   "Value": "59/100"
                  }
                          ],
               "Metascore": "59",
               "imdbRating": "8.4",
               "imdbVotes": "1,038,458",
               "imdbID": "tt7286456",
               "Type": "movie", 
               "DVD": "03 Oct 2019",
               "BoxOffice": "$335,451,311",
               "Production": "Bron Studios, Creative Wealth Media Finance, DC Comics",
               "Website": "N/A",
               "Response": "True"
                         }
    		     """;

    	  this.mockRestServiceServer
    	    .expect(requestTo("http://www.omdbapi.com/?t=joker&apikey=dcda07a9"))
    	    .andRespond(withSuccess(json, MediaType.APPLICATION_JSON));
    	  
    	    String movie = this.movieService.getMovie("joker");
            assertEquals(movie,json);
	}
}
