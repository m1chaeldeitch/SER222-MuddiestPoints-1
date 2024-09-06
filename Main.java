//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static class MyLinkedList {

        private class Node {
            int val;
            Node next;

            public Node() {
                next = null;
            }

            public Node(int value) {
                val  = value;
                next = null;
            }

            private void setValue(int newVal) {
                val = newVal;
            }
        }


        int count; // current number of nodes in the list
        Node head; // the first node in the list

        public MyLinkedList() {
            count = 0;
            head = null;
        }

        public int get(int index) {
            // count = 5
            // max index = 4       0,1,2,3,4

            Node iter = head;
            int returnValue = -1;

            if (index >= count || index < 0) {

            } else {
                for (int i = 0; i < index; i++) {
                    iter = iter.next;
                }
                returnValue = iter.val;
            }

            return returnValue;
        }

        public void addAtHead(int val) {

            Node newNode = new Node(val);

            if (head == null) {
                // case 1: head = null (empty)
                head = newNode;

            } else {
                // case 2 : head != null (non-empty)
                newNode.next = head;
                head = newNode;
            }
            count++;

        }

        public void addAtTail(int val) {
            // 1 loop to the last node (tail)
            // 2 set last node's next to the new node created from val

            Node newNode = new Node(val);
            Node iter = head;

            // case that there is an empty list
            if (head == null) {
                head = newNode;
            } else {

                while (iter.next != null) {
                    iter = iter.next;
                }

                iter.next = newNode;
            }

            count++;
        }
        public void addAtIndex(int index, int val) {

            Node iter = head;
            int returnValue = -1;
            Node newNode = new Node(val);

            if (index > count || index < 0) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
                return;
            }

            if (index == count) {
                addAtTail(val); //TODO come back to make sure requirement met
                return;
            }

            for (int i = 0; i < index - 1; i++) {
                iter = iter.next;
            }

            //at this point - we are 1 index behind the given index from arguemnt
            Node copy = new Node(iter.val);
            copy.next = iter.next;

            iter.next = newNode;
            newNode.next = copy.next;
            count++;
        }

        public void deleteAtIndex(int index) {
            Node iter = head;
            int returnValue = -1;



            if (index >= count || index < 0) {
                return;
            }


            //README!!! CORRECTION FROM VIDEO
            // I said in the video said that this issue occured because
            // some operation of .next.next being null. This is not the case.
            // The issue arises because if you are at the last node, its next component is null.
            // Then by doing .next again, you are trying to do null.next which is NOT allowed due to null not
            // having a .next. This is the issue that was addressed in the fix. No code was edited, but the
            // explanation was incorrect in the video.
            if (index == 0) {
                iter = iter.next;
                head = iter;
                count--;
                return;
            }

            if (index == count -1) {
                for (int i = 0; i < index - 1; i++) {
                    iter = iter.next;
                }

                //iter.next.next = null;
                iter.next = null;
                count--;

            } else {

                for (int i = 0; i < index - 1; i++) {
                    iter = iter.next;
                }

                //at this point - we are 1 index behind the given index from arguemnt
                Node copyOfNextIndexAfterRemoval = iter.next.next;
                iter.next.next = null;
                iter.next = copyOfNextIndexAfterRemoval;
                count--;
            }
        }
    }

    public static void main(String[] args) {
        /**
         * Your MyLinkedList object will be instantiated and called as such:
         * MyLinkedList obj = new MyLinkedList();
         * int param_1 = obj.get(index);
         * obj.addAtHead(val);
         * obj.addAtTail(val);
         * obj.addAtIndex(index,val);
         * obj.deleteAtIndex(index);
         */

        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1); // 1 // 5,1,9,13,15,17,18
        list.addAtHead(5); // 0
        list.addAtTail(9); // 2
        list.addAtTail(11); // 3
        list.addAtTail(13); // 4
        list.addAtTail(15); // 5
        list.addAtTail(17); // 6

        //int test = list.get(5);
        //System.out.println(test);
        list.addAtIndex(7, 18); //7
        list.deleteAtIndex(3);




    }
}