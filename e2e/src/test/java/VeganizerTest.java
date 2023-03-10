import com.javainuse.TestBase;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class VeganizerTest extends TestBase {

    @Test
    public void testVeganize() throws IOException {
        // Given
        //String name = RandomStringUtils.randomAlphabetic( 8 );
//        String rawUrl = "?rawUrl=http://nxp.com";

        // When
        StatusLine statusLine = getRequest(RECIPES_ENDPOINT).getStatusLine();

        // Then
        Assert.assertTrue(statusLine.getStatusCode() == HttpStatus.SC_OK);
    }
}
