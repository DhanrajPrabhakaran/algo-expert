package medium;

public class AddTwoNumbers {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(2);
        l1.next = new LinkedList(4);
        l1.next.next = new LinkedList(7);
        l1.next.next.next = new LinkedList(1);
        LinkedList l2 = new LinkedList(9);
        l2.next = new LinkedList(4);
        l2.next.next = new LinkedList(5);
        System.out.println(addNumber(l1, l2));
        System.out.println(AddTwoNumbers(l1, l2));

    }

    private static LinkedList addNumber(LinkedList l1, LinkedList l2) {
        LinkedList dummy = new LinkedList();
        LinkedList current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int val1 = 0;
            int val2 = 0;

            // get the value
            if (l1 != null)
                val1 = l1.value;
            if (l2 != null)
                val2 = l2.value;

            // add the numbers
            int res = val1 + val2 + carry;
            carry = res / 10;
            res = res % 10;
            LinkedList newNode = new LinkedList(res);
            current.next = newNode;
            current = newNode;

            // update the pointers
            if (l1 != null)
                l1 = l1.next;
            else
                l1 = null;
            if (l2 != null)
                l2 = l2.next;
            else
                l1 = null;
        }
        return dummy.next;
    }
    public static LinkedList AddTwoNumbers(LinkedList l1, LinkedList l2) {
        int sum = 0;

        //first init
        LinkedList resNode = new LinkedList();
        LinkedList copyNode = resNode;

        //start iteration
        while(l1!=null || l2!=null || sum!= 0)
        {
            if(l1!=null)
            {
                sum += l1.value;
                l1 = l1.next;
            }

            if(l2!=null)
            {
                sum += l2.value;
                l2 = l2.next;
            }

            LinkedList newNode = new LinkedList();
            newNode.value = sum%10;
            copyNode.next = newNode;
            copyNode = newNode;

            sum/=10;   //will always be 0 or 1
        }

        return resNode.next;
    }

    public static class LinkedList{
        private int value;
        private LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
        public LinkedList() {
        }

        @Override
        public String toString() {
            return value + " -> " + next + " -> ";
        }
    }
}
