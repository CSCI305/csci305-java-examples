package csci305.examples.java2.generics;

public interface Worklist<T> {
  void add(T item);
  boolean hasMore();
  T remove();
}
