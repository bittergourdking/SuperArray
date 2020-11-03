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

    for (int i = 0; i < 20; i++) {
      yo.add("hi there!");
    }
    for (int i = 0; i < yo.size(); i++) {
      System.out.println( yo.get(i) );
    }
    System.out.println(yo.size());
  }
}
