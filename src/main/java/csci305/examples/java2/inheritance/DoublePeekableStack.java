package csci305.examples.java2.inheritance;

public class DoublePeekableStack extends PeekableStack {

  /**
   * Examine the next-to-top element on the stack.
   * without changing the stack. This should be called
   * only if the stack contains at least two elements.
   * @return the next-to-top String from the stack
   */
  public String doublepeek() {
    String s = remove();
    String r = remove();
    add(r);
    add(s);
    return r;
  }
}
