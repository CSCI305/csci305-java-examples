package csci305.examples.java3;

/**
 * An IntStack is an object that holds a stack of ints.
 */
public class IntStackExcept {
  private Node top = null; // The top Node in the stack

  /**
   * Test whether this stack has more elements.
   * @return true if this stack is not empty
   */
  public boolean hasMore() {
    return (top != null);
  }

  /**
   * Pop the top int from this stack and return it.
   * If the stack is empty we return 0 and leave the
   * stack empty.
   * @return the popped int or 0 if the stack is empty.
   * @throws EmptyStack if stack is empty
   */
  public int pop() throws EmptyStack {
    Node n = top;
    if (n == null) throw new EmptyStack();
    top = n.getLink();
    return n.getData();
  }

  /**
   * Push an int on top of this stack.
   * @param data the String to add
   */
  public void push(int data) {
    top = new Node(data, top);
  }
}
