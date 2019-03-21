package algo;

public class Square {

    private class Coordinate {
        public int x;
        public int y;
    }

    private int distSqr(Coordinate c1, Coordinate c2) {
        return (c1.x - c2.x) * (c1.x - c2.x) + (c1.y - c2.y) * (c1.y - c2.y);
    }

    public boolean isSquare(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4) {
        int d12 = distSqr(c1, c2);
        int d13 = distSqr(c1, c3);
        int d14 = distSqr(c1, c4);

        // If lengths if d12 and d13 are same, then
        // following conditions must met to form a square.
        // 1) Square of length of d14 is same as twice the square of d12
        // 2) Square of length of d23 is same as twice the square of d12
        if(d12 == d13 && 2 * d12 == d14 && 2 * d12 == distSqr(c2, c3)) {
            int d24 = distSqr(c2, c4);
            int d34 = distSqr(c3, c4);
            return d24 == d34 && d24 == d12;
        }
        // The below two cases are similar to above case
        if(d12 == d14 && 2 * d12 == d13 && 2 * d12 == distSqr(c2, c4)) {
            int d23 = distSqr(c2, c3);
            int d34 = distSqr(c3, c4);
            return d23 == d34 && d23 == d12;
        }
        if(d13 == d14 && 2 * d13 == d12 && 2 * d13 == distSqr(c3, c4)) {
            int d23 = distSqr(c2, c3);
            int d34 = distSqr(c3, c4);
            return d23 == d34 && d23 == d13;
        }
        return false;
    }
}
