package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import services.JokeAPIServices;

import java.io.IOException;

public class RandomJokeTests  extends JokeAPIServices {

    @Test
    public static void randomJokeShowResponseCodeTest() throws IOException {

        JokeAPIServices jokeAPIServices1 = new JokeAPIServices();
        int randomJokeShowResponseCode = jokeAPIServices1.randomJokeShowResponseCode();

        Assert.assertEquals(randomJokeShowResponseCode, 200);
    }

    @Test
    public static void idElementNotNullTest() throws IOException {

        JokeAPIServices jokeAPIServices2 = new JokeAPIServices();
        int jokeDetails = jokeAPIServices2.jokeDetails();

        Assert.assertNotNull(jokeDetails);
    }

}
