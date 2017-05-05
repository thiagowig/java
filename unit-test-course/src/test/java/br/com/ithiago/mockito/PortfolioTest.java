package br.com.ithiago.mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by tfonseca on 05/05/2017.
 */
public class PortfolioTest {

    private Portfolio portfolio;

    private StockService stockService;

    public static void main(String[] args) {
        PortfolioTest test = new PortfolioTest();
        test.setup();
        System.out.println(test.testMarketValue() ? "pass" : "fail");
    }

    public void setup() {
        portfolio = new Portfolio();

        stockService = mock(StockService.class);

        portfolio.setStockService(stockService);
    }

    public boolean testMarketValue() {
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1","Google", 10);
        Stock microsoftStock = new Stock("2","Microsoft",100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        //add stocks to the portfolio
        portfolio.setStocks(stocks);

        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();

        return marketValue == 100500.0;
    }


}
