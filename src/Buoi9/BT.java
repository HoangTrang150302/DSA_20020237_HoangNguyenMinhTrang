package Buoi9.Demo;

public class BT<Key> {

    private final Key key;
    private BT<Key> left;
    private BT<Key> right;

    public BT(Key key)
    {
        this.key = key;
    }

    public BT(Key key, BT<Key> left, BT<Key> right)
    {
        this(key);
        this.left = left;
        this.right = right;
    }

    public String toString()
    {
        return key.toString();
    }

    public void traversePreOrder() // parent left right A  B D  E C F G
    {
        System.err.print("(" + this);
        if (left != null)
        {
            left.traversePreOrder();
        }
        if (right != null)
        {
            right.traversePreOrder();
        }
        System.err.print(")");
    }

    public void traverseInOrder()
    {
        System.err.print(" (");
        if (left != null)
        {
            left.traverseInOrder();
        }
        System.err.print(this);
        if (right != null)
        {
            right.traverseInOrder();
        }
        System.err.print(") ");
    }

    public void traversePostOrder()
    {
        System.err.print(" (");
        if (left != null)
        {
            left.traversePostOrder();
        }
        if (right != null)
        {
            right.traversePostOrder();
        }
        System.err.print(this);
        System.err.print(") ");
    }

//    public Key findMax()
//    {
//
//    }

    public int count()
    {
        int leftCount = left == null ? 0 : left.count();
        int rightCount = right == null ? 0 : right.count();
        return 1 + leftCount + rightCount;
    }

    public int height()
    {
        int leftHeight = left == null ? -1 : left.height();
        int rightHeight = right == null ? -1 : right.height();
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean contains(Key key)
    {
        return key.equals(this.key) || (left != null && left.contains(key))
                || (right != null && right.contains(key));
    }

    public static void main(String []args)
    {
        BT<String> d = new BT<>("D");
        BT<String> e = new BT<>("E");
        BT<String> f = new BT<>("F");
        BT<String> g = new BT<>("G");
        BT<String> b = new BT<>("B", d, e);
        BT<String> c = new BT<>("C", f, g);
        BT<String> a = new BT<>("A", b, c);
        System.err.println(a);

        System.out.println("traversePreOrder");
        a.traversePreOrder(); // parent left right A  B D  E C F G
        System.out.println("traverseInOrder");
        a.traverseInOrder(); // left parent right D B E  A  F C G
        System.out.println("traversePostOrder");
        a.traversePostOrder(); // left right parent D E B  F G C  A
        //Tinh gia tri bieu thuc bang postorder, inorder de in ra bieu thuc

        System.err.println(a.contains("B"));
        System.err.println("Count a: " + a.count()); //7
        System.err.println("Count b: " + b.count()); //3
        System.err.println("Count d: " + d.count()); //1

        System.err.println("Height a: " + a.height());
        System.err.println("Height b: "+ b.height());
        System.err.println("Height c: " + c.height());
        //System.err.println(a.max(""));
    }
}
