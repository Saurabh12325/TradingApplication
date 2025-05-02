package com.Trading.Trading.Service;

import com.Trading.Trading.Entity.Coin;
import com.Trading.Trading.Repository.CoinRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;


import java.util.List;
@Service
public class CoinsServiceimpl implements  CoinService{

   @Autowired
    private CoinRepository coinRepository;//use for the communication of the external Api
   @Autowired
   private ObjectMapper objectMapper;  //object mapper is to serializattion("Convert javaobject to json") and deserialization("Json to javaObject")

    @Override
    public List<Coin> getCoinList(int page) throws Exception {
        String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&per_page=10&page="+page;
        RestTemplate restTemplate = new RestTemplate();
        try{
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
            List<Coin> coinList = objectMapper.readValue(response.getBody(), new TypeReference<List<Coin>>(){});
            return coinList;
        }catch (HttpClientErrorException  | HttpServerErrorException e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public String getMarkerChart(String coinId, int days) {
        return "";
    }

    @Override
    public String getCoinDetail(String coinId) {
        return "";
    }

    @Override
    public String findById(int coinId) {
        return "";
    }

    @Override
    public String searchCoin(String keyword) {
        return "";
    }

    @Override
    public String getTo50CoinsByMarketCapRank() {
        return "";
    }

    @Override
    public String GetTreadingCoins() {
        return "";
    }
}
