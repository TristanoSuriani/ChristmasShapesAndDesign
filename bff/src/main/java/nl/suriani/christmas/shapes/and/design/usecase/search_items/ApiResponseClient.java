package nl.suriani.christmas.shapes.and.design.usecase.search_items;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;

@Service
public class ApiResponseClient {

    private final RestTemplate restTemplate;
    private final String url = "http://localhost:1337/api/items";
    private static final String BEARER_TOKEN = "8a789dbf4de675144cdf32aebfb3268c45298de3350986464ed73ed046aa65674635a32b64edfcf2702a996515b268973454dba683a916a3e815a520b1aab4ec9d61b6b43d33736a66307669b30eafb9feadba3867975047a6296e79d9451137a14a48a492cbe19965908c3eda5e25b221e5c2f1120a804c45e628e6299fb636";

    public ApiResponseClient() {
        this.restTemplate = new RestTemplate();
    }

    public ApiResponse fetchApiResponse() {
        var headers = new HttpHeaders();
        headers.setBearerAuth(BEARER_TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var requestEntity = new HttpEntity<>(headers);
        var response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                ApiResponse.class
        );

        return Objects.requireNonNull(response.getBody());
    }
}