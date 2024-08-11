package com.acciojob.RepublicAccio.service;

import com.acciojob.RepublicAccio.Response.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;

    String baseUrl = "https://newsapi.org/v2/top-headlines";
    String url1 = "http://localhost:9999/person";

    public NewsResponse getNews(String countryCode,
                                String apiKey) {
        String url = prepareUrl(countryCode,apiKey);
        return restTemplate.getForObject(url, NewsResponse.class);

    }

    private String prepareUrl(String countryCode,
                              String apiKey) {
        String url = baseUrl + "?country=" +countryCode + "&apiKey=" + apiKey;
        return url;
    }
}
