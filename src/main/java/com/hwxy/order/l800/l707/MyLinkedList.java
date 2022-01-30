package com.hwxy.order.l800.l707;

/**
 * 707. 设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 * 
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是
 * 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index
 * 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hwxy
 * @date 2022/01/30
 **/
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        // [[],[1],[3],[1,2],[1],[1],[1]]
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);

        // ["MyLinkedList","addAtHead","deleteAtIndex"]
        // [[],[1],[0]]
    }


    private int size;

    private MyLinkedListNode virtualNode;

    public MyLinkedList() {
        size = 0;
        virtualNode = new MyLinkedListNode();
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        MyLinkedListNode cur = virtualNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * 
     * @param val
     */
    public void addAtHead(int val) {
        MyLinkedListNode nNode = new MyLinkedListNode(val);
        nNode.next = virtualNode.next;
        virtualNode.next = nNode;
        size++;
    }

    /**
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     * 
     * @param val
     */
    public void addAtTail(int val) {
        MyLinkedListNode nNode = new MyLinkedListNode(val);
        MyLinkedListNode cur = virtualNode;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = nNode;
        size++;
    }

    /**
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * 
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
            return;
        } else if (index > size) {
            return;
        } else if (index < 0) {
            addAtHead(val);
            return;
        }
        // 从vir开始
        MyLinkedListNode cur = virtualNode;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        MyLinkedListNode nNode = new MyLinkedListNode(val);
        nNode.next = cur.next;
        cur.next = nNode;
        size++;
    }

    /**
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     * 
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        // 从vir开始防止删head
        MyLinkedListNode cur = virtualNode;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    private static class MyLinkedListNode {
        public int val;
        public MyLinkedListNode next;

        public MyLinkedListNode() {}

        public MyLinkedListNode(int val) {
            this.val = val;
        }

        public MyLinkedListNode(int val, MyLinkedListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
