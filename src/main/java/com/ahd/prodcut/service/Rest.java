package com.ahd.prodcut.service;


import com.ahd.prodcut.model.CityResponse;
import com.ahd.prodcut.model.Citys;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class Rest<T> {
    RestTemplate  restTemplate;

    public Rest() {
        restTemplate= new RestTemplate();
    }

    public List<Citys> fetch(String uri){
        CityResponse response = restTemplate.getForObject(
                uri,
                CityResponse.class);
        List<Citys> date = response.getCitys();
        return date;
    }






}
