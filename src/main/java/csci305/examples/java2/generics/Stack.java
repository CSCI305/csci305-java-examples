package csci305.examples.java2.generics;

public class Stack<T> implements Worklist<T> {

  private Node<T> top = null;

  public void add(T data) {
    top = new Node<T>(data, top);
  }

  public boolean hasMore() {
    return top != null;
  }

  public T remove() {
    Node<T> n = top;
    top = n.getLink();
    return n.getData();
  }
}
