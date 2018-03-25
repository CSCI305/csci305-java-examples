package csci305.examples.java2.inheritance;

/**
 * A PeekableStack is an object that does everything a
 * Stack can do and can also peek at the top element
 * of the stack without popping it off.
 */
public class PeekableStack extends Stack {

  /**
   * Examine the top element on the stack, without
   * popping it off. This shoudl be called only if the
   * stack is not empty.
   * @return the top String from the stack
   */
  public String peek() {
    String s = remove();
    add(s);
    return s;
  }
}
