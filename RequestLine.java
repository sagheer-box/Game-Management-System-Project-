public class RequestLine {
    private Node head;
    private Node tail;
    private int count;

    public RequestLine() {
        head = null;
        tail = null;
        count = 0;
    }

    public void addRequest(Gear g) {
        Node newNode = new Node(g);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    public Gear fulfillRequest() {
        if (head == null) {
            return null;
        }
        Gear data = head.gear;
        head = head.next;
        count--;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public Gear nextUp() {
        if (head == null) {
            return null;
        }
        return head.gear;
    }

    public boolean queueEmpty() {
        return head == null;
    }

    public void showLine() {
        if (head == null) {
            System.out.println("Request queue is empty.");
            return;
        }
        System.out.println("\n========== REQUEST QUEUE ==========");
        System.out.println(String.format("| %-4s | %-25s | %-20s | %-8s | %-10s |", "POS", "Gear Title", "Category", "Stock", "Strength"));
        System.out.println("===================================================================================================");
        Node current = head;
        int position = 1;
        while (current != null) {
            System.out.println(String.format("| %-4d | %s", position, current.gear.toString().substring(2)));
            current = current.next;
            position++;
        }
        System.out.println("===================================================================================================\n");
    }

    private class Node {
        Gear gear;
        Node next;

        Node(Gear gear) {
            this.gear = gear;
            this.next = null;
        }
    }
}
