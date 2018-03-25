package csci305.examples.java3;

public class Test {
  public static void main(String[] args) {
    try {
      int i = Integer.parseInt(args[0]);
      int j = Integer.parseInt(args[1]);

      System.out.println(i / j);
    } catch (ArithmeticException a) {
      System.out.println("You're dividing by zero!");
    } catch (ArrayIndexOutOfBoundsException a) {
      System.out.println("Requires two parameters.");
    } catch (RuntimException a) {
      System.out.println("Runtime exception");
    }
  }
}
