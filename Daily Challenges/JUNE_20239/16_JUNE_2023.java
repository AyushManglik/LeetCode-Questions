import java.math.BigInteger;

class Solution {
    private static final long MODULUS_LONG = 1_000_000_007;
    private static final BigInteger MODULUS_BIG = BigInteger.valueOf(MODULUS_LONG);

    public int numOfWays(final int[] nums) {
        final Bst bst = new Bst(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            bst.add(nums[i]);
        }
        return countWays(bst) - 1;
    }

    private static int countWays(final Bst bst) {
        if (bst == null) {
            return 1;
        } else if (bst.left == null) {
            return countWays(bst.right);
        } else if (bst.right == null) {
            return countWays(bst.left);
        } else {
            final long a = countWays(bst.left);
            final long b = countWays(bst.right);
            final long c = nCr(bst.size - 1, bst.left.size);
            // we want a * b * c % MODULUS
            return (int) ((a * b) % MODULUS_LONG * c % MODULUS_LONG);
        }
    }

    private static int nCr(final int n, final int r) {
        if (n < 2 * r) {
            return nCr(n, n - r);
        }
        // There's probably a smarter way to do this without needing
        // BigInteger, but I can't think of it . . .
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < r; ++i) {
            result = result.multiply(BigInteger.valueOf(n - i));
            result = result.divide(BigInteger.valueOf(i + 1));
        }
        return result.mod(MODULUS_BIG).intValue();
    }

    private static final class Bst {
        private final int rootVal;
        private Bst left;
        private Bst right;
        private int size;

        public Bst(final int val) {
            this.rootVal = val;
            this.size = 1;
        }

        public void add(final int val) {
            if (val < this.rootVal) {
                if (this.left == null) {
                    this.left = new Bst(val);
                } else {
                    this.left.add(val);
                }
            } else {
                if (this.right == null) {
                    this.right = new Bst(val);
                } else {
                    this.right.add(val);
                }
            }
            this.size++;
        }
    }
}
