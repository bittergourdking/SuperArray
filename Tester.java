public class Tester {
  public static void main(String[] args) {
    SuperArray words = new SuperArray();
    SuperArray yo = new SuperArray();
    System.out.println(words.size());
    words.add("kani");
    words.add("uni");
    words.add("ebi");
    for (int i = 0; i < words.size(); i++) {
      System.out.println( words.get(i) );
    }
    System.out.println(words.size());

    for (int i = 0; i < 5; i++) {
      yo.add("hi there!");
    }
    for (int i = 0; i < yo.size(); i++) {
      System.out.println( yo.get(i) );
    }
    System.out.println(yo.size());
    //testing new methods
    words.add(1, "hi");
    System.out.println(words.size());
    System.out.println(words.toString());
    System.out.println(words.contains("ebi"));
    yo.add("mark temple wahooooooo");
    System.out.println(yo.remove(1));
    System.out.println(words.indexOf("uni"));
    System.out.println(words);
    System.out.println(words.toArray());

    try {
      System.out.println(words.get(20));
      System.out.println(words.set(20, "yo"));
      words.add(20, "yo");
      System.out.println(words.remove(20));
    }
    catch (IllegalArgumentException e1) {
      System.out.println("test");
    }
    catch (IndexOutOfBoundsException e2) {
      System.out.println("test");
    }
  }
}
