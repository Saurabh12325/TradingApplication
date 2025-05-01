package com.Trading.Trading.Service;

import com.Trading.Trading.Entity.Coin;

import java.util.List;

public interface CoinService {
    List<Coin> getCoinList(int page);

    String getMarkerChart(String coinId,int days);
    String getCoinDetail(String coinId);
    String findById(int coinId);
    String searchCoin(String keyword);
    String getTo50CoinsByMarketCapRank();
    String GetTreadingCoins();

}
