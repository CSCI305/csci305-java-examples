package csci305.examples.java2.generics;

public class Node<T> {
  private T data;
  private Node<T> link;

  public Node(T theData, Node<T> theLink) {
    data = theData;
    link = theLink;
  }

  public T getData() {
    return data;
  }

  public Node<T> getLink() {
    return link;
  }
}
