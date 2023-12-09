class LinkedListScratch {
    Node head;
    private int size = 0;

    public class Node {
        int data;
        Node next;

        Node() {
           
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void printList(Node currentNode) {
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.data < list2.data) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public Node mergeTwoListsWithoutRecursion(Node list1, Node list2) {
        Node newHead = new Node();
        Node resultNode = newHead;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                resultNode.next = list1;
                list1 = list1.next;
            } else {
                resultNode.next =list2;
                list2 = list2.next;
            }
            resultNode = resultNode.next;
            
        }
        if (list1 != null) {
            resultNode.next = list1 ;
        }
        if (list2 != null) {
            resultNode.next = list2;
        }

        return newHead.next;
    }

    public static void main(String args[]) {
        LinkedListScratch list = new LinkedListScratch();
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(3);
        list.addFirst(1);
        list.printList();
        LinkedListScratch list2 = new LinkedListScratch();
        list2.addFirst(7);
        list2.addFirst(4);
        list2.addFirst(2);
        list2.addFirst(1);
        list2.printList();
        // LinkedListScratch finalList = new LinkedListScratch();
        // Node x = finalList.mergeTwoLists(list.head, list2.head);
        // finalList.printList(x);
        LinkedListScratch finalList2 = new LinkedListScratch();
        Node y = finalList2.mergeTwoListsWithoutRecursion(list.head, list2.head);
        finalList2.printList(y);
    }
}
