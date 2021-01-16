package cn.even.test;

public class Node<E> {

    E current;
    Node<E> next;

    Node(E element) {
        this.current = element;
        this.next = null;
    }

    public E getCurrent() {
        return current;
    }

    public void setCurrent(E current) {
        this.current = current;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNode(int i) {
        int count = 0;
        Node<E> current = this;
        while (count < i) {
            current = current.next;
            count++;
        }
        return current;
    }

    public void getAllNode(){
        Node node = this;
        while (node != null) {
            System.out.println(node.current);
            node = node.next;
        }
    }

    public void insertNode(Node<E> lastNode, Node<E> nextNode){
        this.setNext(nextNode);
        lastNode.setNext(this);
    }

    public void deleteNextNode(){
        Node next = this.next.next;
        Node last = this.next;

    }

}
