// Basic solution
public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }
 
    @Override
    ListItem next() {
        return rightLink;
    }
 
    @Override
    ListItem setNext(ListItem rightLink) {
        return this.rightLink = rightLink;
    }
 
    @Override
    ListItem previous() {
        return leftLink;
    }
 
    @Override
    ListItem setPrevious(ListItem leftLink) {
        return this.leftLink = leftLink;
    }
 
    @Override
    int compareTo(ListItem other) {
        int x = Integer.parseInt(String.valueOf(value)); // parse and return int
        // int x = Integer.parseInt("" + value); // alternative: concatenate, parse and return int
        // int x = Integer.valueOf("" + value); // alternative: concatenate and return Integer
        int y = Integer.parseInt(String.valueOf(other.value));
        if (x == y) {
            return 0;
        }
        return x > y ? 1 : -1;
        // return x == y ? 0 : (x > y ? 1 : -1); // nested ternary operator
    }
}