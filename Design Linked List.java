class MyLinkedList {

    /** Initialize your data structure here. */
    class ListNode{
        int val;
        ListNode prev, next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head,tail;
    int size;
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) return -1;
        ListNode dummy = head;
        while (index-- > 0) dummy = dummy.next;
        return dummy.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        } else {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null) {
            tail = new ListNode(val);
            head = tail;
        } else {
            ListNode newNode = new ListNode(val);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        else if (index == size) addAtTail(val);
        else if (index == 0) addAtHead(val);
        else {
            ListNode pointer = head;
            if (index > size / 2) {
                pointer = tail;
                index = size - index - 1;
                while (index-- > 0) pointer = pointer.prev;
            } else {
                while (index-- > 0) pointer = pointer.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.prev = pointer.prev;
            pointer.prev.next = newNode;
            pointer.prev = newNode;
            newNode.next = pointer;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            ListNode tmp = head.next;
            if (tmp != null) {
                tmp.prev = null;
            } else tail = null;
            head.next = null;
            head = tmp;
        } else if (index == size - 1) {
            ListNode tmp = tail.prev;
            if (tmp != null) {
                tmp.next = null;
            }
            else head = null;
            tail.prev = null;
            tail = tmp;
        } else {
            ListNode tmp = head;
            if (index > size / 2) {
                tmp = tail;
                index = size - index - 1;
                while (index-- > 0) tmp = tmp.prev;
            } else {
                while (index-- > 0) tmp = tmp.next;
            }
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            tmp.prev = null;
            tmp.next = null;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
