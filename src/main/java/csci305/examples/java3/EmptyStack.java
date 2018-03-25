package csci305.examples.java3;

public class EmptyStack extends Exception {
  public EmptyStack() {
    super("Trying to pop an empty stack.");
  }
}
