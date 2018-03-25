package csci305.examples.java2.inheritance;

/**
 * A Node is an object that holds a String and
 * a link to the next Node. It can be used to
 * build linked lists of Strings.
 */
public class Node {
  private String data; // Each node has a String...
  private Node link; // ... and a link to the next Node

  /**
   * Node Constructor
   * @param theData the String to store in this Node
   * @param theLink a link to the next Node
   */
  public Node(String theData, Node theLink) {
    data = theData;
    link = theLink;
  }

  /**
   * Accessor for the String data stored in this Node.
   * @return our String item
   */
  public String getData() {
    return data;
  }

  /**
   * Accessor for the link to the next Node.
   * @return the next Node
   */
  public Node getLink() {
    return link;
  }
}
