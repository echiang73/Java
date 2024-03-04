// Basic solution
public class MyLinkedList implements NodeList {
    private ListItem root;
 
    public MyLinkedList(ListItem root) {
        this.root = root;
    }
    
    @Override
    public ListItem getRoot() {
        return root;
    }
 
    @Override
    public boolean addItem(ListItem node) {
        // the list is empty so the item becomes the head of the list
        if (root == null) {
            root = node;
            return true;
        }

        ListItem current = root;
        while (true) {
            // if there is no next item, we insert this item at the end of the list
            if (current.next() == null) {
                current.setNext(node);
                node.setPrevious(current);
                return true;
            }
            // if there is a next item and new item is smaller, insert this item before current
            if (current.compareTo(node) == 1) {
                root = node;
                root.setNext(current);
                current.setPrevious(root);
                return true;
            }
            return false;
        }
    }
 
    @Override
    public boolean removeItem(ListItem node) {
        if (root == null || node == null) {
            return false;
        }
        int nodeValue = Integer.parseInt("" + node.getValue());
        ListItem current = root;
        while (true) {
            int currentValue = Integer.parseInt("" + current.getValue());
            if (currentValue == nodeValue) {
                if (current == root) {
                    root = (current.next() == null) ? null : current.next();
                    return true;
                } else if (current.next() == null) {
                    current.previous().setNext(null);
                    return true;
                }
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                return true;
            } else if (nodeValue < currentValue) {
                return false;
            }
            current = current.next();
            if (current == null) {
                return false;
            }
        }
    }
 
    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.print("The list is empty");
            return;
        }
        ListItem current = root;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.next();
        }
    }
}