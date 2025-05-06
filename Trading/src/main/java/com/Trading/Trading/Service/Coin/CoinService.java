package com.Trading.Trading.Service.Coin;

import com.Trading.Trading.Entity.Coin;

import java.util.List;

public interface CoinService {
    List<Coin> getCoinList(int page) throws Exception;

    String getMarketChart(String coinId,int days) throws Exception;
    String getCoinDetail(String coinId) throws Exception;
    Coin findById(String coinId) throws Exception;
    String searchCoin(String keyword) throws Exception;
    String getTo50CoinsByMarketCapRank() throws Exception;
    String GetTreadingCoins() throws Exception;

}
