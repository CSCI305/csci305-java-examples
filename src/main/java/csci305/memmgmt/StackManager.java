package csci305.memmgmt;

public class StackManager {
  private int[] memory; // the memory we manager
  private int top; // index of top (lowest) stack block

  /**
   * StackManager constructor
   * @param initialMemory the int[] of memory to manage
   */
  public StackManager(int[] initialMemory) {
    memory = initialMemory;
    top = memory.length;
  }

  /**
   * Allocate a block and return its address
   * @param requestSize int size of blcok, > 0
   * @return block address
   * @throws StackOverflowError if out of stack space
   */
  public int push(int requestSize) {
    int oldtop = top;
    top -= (requestSize + 1); // extra word for oldtop
    if (top < 0)
      throw new StackOverflowError();
    memory[top] = oldtop;
    return top + 1;
  }

  /**
   * Pop the top stack frame. This works only if the
   * stack is not empty.
   */
  public void pop() {
    top = memory[top];
  }
}
