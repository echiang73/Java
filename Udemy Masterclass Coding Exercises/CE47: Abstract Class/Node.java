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
        int x = Integer.parseInt(String.valueOf(value));
        int y = Integer.parseInt(String.valueOf(other.value));
        if (x == y) {
            return 0;
        }
        return x > y ? 1 : -1;
    }
}


// Alternative compareTo() method using ternary operator and by concatenating, parse and return int
    @Override
    int compareTo(ListItem other) {
        int x = Integer.parseInt("" + value);
        int y = Integer.parseInt("" + other.value);
        return x == y ? 0 : (x > y ? 1 : -1);
    }


// Alternative compareTo() method by concatenating, and use Integer.valueOf() to return Integer
    @Override
    int compareTo(ListItem other) {
        int x = Integer.valueOf("" + value);
        int y = Integer.valueOf("" + other.value);
        return x == y ? 0 : (x > y ? 1 : -1);
    }