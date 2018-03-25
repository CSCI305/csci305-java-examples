package csci305.examples.java2.inheritance;

/**
 * A Stack is an object that holds a collection of Strings
 */
public class Stack implements Worklist {

  private Node top = null; // The top Node in the Stack

  /**
   * Push a String on top of this stack.
   * @param data the String to add
   */
  public void add(String data) {
    top = new Node(data, top);
  }

  /**
   * Test whether this stack has more elements.
   * @return true if this stack is not empty
   */
  public boolean hasMore() {
    return (top != null);
  }

  /**
   * Pop the top String from this tack and return it.
   * This should be called only if the stack is not empty
   * @return the popped String
   */
  public String remove() {
    Node n = top;
    top = n.getLink();
    return n.getData();
  }
}
