package algo;

import java.util.Date;

/**
 * @author sarvesh
 * @since
 */
public class RentalTime /*implements Comparable<RentalTime>*/{
    Date start;
    Date end;

    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

//    @Override
//    public int compareTo(RentalTime other) {
//        return this.start.compareTo(other.end) <= 0 && this.end.compareTo(other.start) <= 0;
//    }
}
