import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class TestBase {
    public static String NAVIGATION_ROUTE = "http://veganizeme4.us-east-1.elasticbeanstalk.com/";
    public static String RECIPES_ENDPOINT = "/recipes";
    public static String RECIPE_ENDPOINT = "/recipe";
    public static String VEGANIZE_ENDPOINT = "/veganize";

    public CloseableHttpResponse getRequest(String uri) throws IOException {
        HttpUriRequest request = new HttpGet(
                NAVIGATION_ROUTE +
                        uri);
        CloseableHttpResponse response = executeRequest(request);
        response.close();
        return response;
    }

    private CloseableHttpResponse executeRequest(HttpUriRequest request) throws IOException {
        return HttpClientBuilder.create().build().execute(request);
    }
}