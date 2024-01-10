import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private static GenericContainer<?> myFirstContainer = new GenericContainer<>("ServiceAutorization1")
            .withExposedPorts(8080);

    @Container
    private static GenericContainer<?> mySecondContainer = new GenericContainer<>("ServiceAutorization2")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        myFirstContainer.start();
        mySecondContainer.start();
    }

    @Test
    void testMyFirstContainer() {
        String url = "http://localhost:" + myFirstContainer.getMappedPort(8080) + "/endpoint";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals("expectedResponse", response.getBody());
    }

    @Test
    void testMySecondContainer() {
        String url = "http://localhost:" + mySecondContainer.getMappedPort(8081) + "/endpoint";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals("expectedResponse", response.getBody());
    }
}