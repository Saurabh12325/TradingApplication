package com.Trading.Trading.Controller;

import com.Trading.Trading.Entity.Coin;
import com.Trading.Trading.Service.CoinService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coins")
public class CoinController {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CoinService coinService;


    @GetMapping
  public ResponseEntity<List<Coin>>getCoinList(@RequestParam("page")int page) throws Exception{
        List<Coin> coinList = coinService.getCoinList(page);
        return new ResponseEntity<>(coinList, HttpStatus.ACCEPTED);
    }
    @GetMapping("/{coinId}/chart")
    public ResponseEntity<JsonNode>getMarketChart(@PathVariable String coinId,@RequestParam("days")int days) throws Exception{
         String res = coinService.getMarketChart(coinId,days);
         JsonNode jsonNode = objectMapper.readTree(res);
        return new ResponseEntity<>(jsonNode, HttpStatus.ACCEPTED);
    }
    @GetMapping
    public ResponseEntity<JsonNode> searchCoin(@RequestParam("q") String keyword)throws Exception{
        String coin = coinService.searchCoin(keyword);
        JsonNode jsonNode = objectMapper.readTree(coin);
        return new ResponseEntity<>(jsonNode, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<JsonNode> getTop50coinByMarketCapRank() throws Exception{
        String coin = coinService.getTo50CoinsByMarketCapRank();
        JsonNode jsonNode = objectMapper.readTree(coin);
        return new ResponseEntity<>(jsonNode, HttpStatus.OK);
    }

    @GetMapping("/treading")
    public ResponseEntity<JsonNode> getTreadingCoin()throws Exception{
        String coin = coinService.GetTreadingCoins();
        JsonNode jsonNode = objectMapper.readTree(coin);
        return new ResponseEntity<>(jsonNode, HttpStatus.OK);
    }
    @GetMapping("/details/{coinId}")
    ResponseEntity<JsonNode> getCoinDetails(@PathVariable String coinId)throws Exception{
        String coin = coinService.getCoinDetail(coinId);
        JsonNode jsonNode = objectMapper.readTree(coin);
        return new ResponseEntity<>(jsonNode, HttpStatus.OK);
    }

}
