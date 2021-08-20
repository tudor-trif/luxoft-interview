package services;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import tests.BaseTest;

import java.io.IOException;
import java.io.InputStream;

public class JokeAPIServices extends BaseTest {

    public int randomJokeShowResponseCode() throws IOException {
        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://official-joke-api.appspot.com/random_joke");
        HttpResponse httpResponse = httpclient.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return statusCode;
    }

    public int jokeDetails() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://official-joke-api.appspot.com/random_joke");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        int jokeResponseCode = httpResponse.getStatusLine().getStatusCode();
        String reasonPhrase = httpResponse.getStatusLine().getReasonPhrase();
        System.out.println("Response was: " + jokeResponseCode + " - " + reasonPhrase);
        InputStream bodyAsInputStream = httpResponse.getEntity().getContent();
        String responseBody = IOUtils.toString(bodyAsInputStream);
        System.out.println(responseBody);
        JSONObject jsonObject = new JSONObject(responseBody);
        System.out.println(jsonObject.getInt("id"));
        return jsonObject.getInt("id");
    }

}
