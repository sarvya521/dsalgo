package algo;

/**
 * @author sarvesh
 * @since
 */
public class Account implements OnlineAccount, Comparable<Account>{

    int noOfRegularMovies, noOfExclusiveMovies;
    String ownerName;
    Integer monthlyCost;

    public Account(int noOfRegularMovies, int noOfExclusiveMovies, String ownerName) {
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.ownerName = ownerName;
    }

    public int monthlyCost() {
        this.monthlyCost =
                basePrice + noOfRegularMovies * regularMoviePrice + noOfExclusiveMovies * exclusiveMoviePrice;
        return this.monthlyCost;
    }

    @Override
    public int compareTo(Account account) {
        return this.monthlyCost.compareTo(account.monthlyCost);
    }

    @Override
    public String toString() {
        return "Owner is "+ownerName+" and monthly cost is "+monthlyCost+" USD";
    }
}
