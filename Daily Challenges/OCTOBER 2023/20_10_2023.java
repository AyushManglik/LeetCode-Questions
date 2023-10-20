/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Deque<ListIterator<NestedInteger>> itStack;
    private Integer currInt;

    public NestedIterator(List<NestedInteger> nestedList) {
        itStack = new ArrayDeque<>();
        itStack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }

        Integer nextVal = currInt;
        currInt = null;
        return nextVal;
    }

    @Override
    public boolean hasNext() {
        getNextInt();
        return currInt != null;
    }

    private void getNextInt() {
        if (currInt != null) {
            return;
        }

        while (!itStack.isEmpty()) {
            if (!itStack.peek().hasNext()) {
                itStack.pop();
                continue;
            }

            NestedInteger nextNested = itStack.peek().next();
            if (nextNested.isInteger()) {
                currInt = nextNested.getInteger();
                return;
            }

            itStack.push(nextNested.getList().listIterator());
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
