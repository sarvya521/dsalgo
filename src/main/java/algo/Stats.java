package algo;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Stats {

	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		
		class Stock {
			private String symbol;
			private double totalPrice;
			private int counter;
			public String getSymbol() {
				return symbol;
			}
			public void setSymbol(String symbol) {
				this.symbol = symbol;
			}
			public double getTotalPrice() {
				return totalPrice;
			}
			public void setTotalPrice(double totalPrice) {
				this.totalPrice = totalPrice;
			}
			public int getCounter() {
				return counter;
			}
			public void setCounter(int counter) {
				this.counter = counter;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + getOuterType().hashCode();
				result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Stock other = (Stock) obj;
				if (!getOuterType().equals(other.getOuterType()))
					return false;
				if (symbol == null) {
					if (other.symbol != null)
						return false;
				} else if (!symbol.equals(other.symbol))
					return false;
				return true;
			}
			private StatisticsAggregatorImpl getOuterType() {
				return StatisticsAggregatorImpl.this;
			}
		}
		
		private ConcurrentHashMap<String, Stock> map = new ConcurrentHashMap<String, Stock>();

		@Override
		public void putNewPrice(String symbol, double price) {
			Stock stock = null;
			if(map.containsKey(symbol)) {
				stock = map.get(symbol);
				stock.setCounter(stock.getCounter()+1);
				stock.setTotalPrice(stock.getTotalPrice()+price);
			} else {
				stock = new Stock();
				stock.setSymbol(symbol);
				stock.setTotalPrice(price);
				stock.setCounter(1);
				map.put(symbol, stock);
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			Stock stock = map.get(symbol);
			if(stock == null) {
				throw new NoSuchElementException("Symbol data not found!");
			}
			return stock.getTotalPrice() / stock.getCounter();
		}

		@Override
		public int getTickCount(String symbol) {
			Stock stock = map.get(symbol);
			if(stock == null) {
				throw new NoSuchElementException("Symbol data not found!");
			}
			return stock.getCounter();
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}

}
