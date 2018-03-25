package csci305.examples.java2.generics;

public class Driver {

  public static void main(String[] args) {
    Worklist<String> s1 = new Stack<>();
    Worklist<Integer> s2 = new Stack<>();

    s1.add("Hello");
    String s = s1.remove();
    s2.add(1);
    int i = s2.remove(i)

    System.out.println("s = " + s);
    System.out.println("i = " + i);
  }
}
