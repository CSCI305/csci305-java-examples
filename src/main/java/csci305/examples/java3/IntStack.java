package csci305.examples.java3;

/**
 * An IntStack is an object that holds a stack of ints.
 */
public class IntStack {
  private Node top = null; // The top Node in the stack
  private boolean error = false;

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
   */
  public int pop() {
    Node n = top;
    if (n == null) {
      error = true;
      return 0;
    }
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

  /**
   * Return the error flag for this stack. The error
   * flag is set true if an empty stack is ever popped.
   * It can be reset to false by calling resetError().
   * @return the error flag
   */
  public boolean getError() {
    return error;
  }

  /**
   * Reset the error flag. We set it to false.
   */
  public void resetError() {
    error = false;
  }
}
