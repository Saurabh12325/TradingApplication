package com.Trading.Trading.Controller;

import com.Trading.Trading.Entity.Coin;
import com.Trading.Trading.Service.CoinService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping
    public ResponseEntity<List<Coin>>getCoinList(@RequestParam("page")int page) throws Exception{
        List<Coin> coinList = coinService.getCoinList(page);
        return new ResponseEntity<>(coinList, HttpStatus.ACCEPTED);
    }

}
