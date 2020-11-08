public class Demo{
  public static void removeDuplicates(SuperArray s){
    String checker = "";
    for (int i = 0; i < s.size(); i++) {
      checker = s.get(i);
      for (int j = i + 1; j < s.size(); j++) {
        if (s.get(j).equals(checker)) {
          s.remove(j);
          j--;
        }
      }
    }
  }

  public static SuperArray findOverlap(SuperArray a, SuperArray b) {
    SuperArray answer = new SuperArray();
    SuperArray aHelper = new SuperArray();
    SuperArray bHelper = new SuperArray();
    for (int i = 0; i < a.size(); i++) {
      aHelper.add(a.get(i));
    }
    for (int i = 0; i < b.size(); i++) {
      bHelper.add(b.get(i));
    }
    removeDuplicates(aHelper);
    removeDuplicates(bHelper);
    String checker = "";
    for (int i = 0; i < aHelper.size(); i++) {
      checker = aHelper.get(i);
      for (int j = 0; j < bHelper.size(); j++) {
        if (bHelper.get(j).equals(checker)) {
          answer.add(bHelper.get(j));
        }
      }
    }
    return answer;
  }

  public static SuperArray zip(SuperArray a, SuperArray b) {
    SuperArray answer = new SuperArray(a.size() + b.size());
    SuperArray helper = new SuperArray();
    int size = 0;
    if (a.size() > b.size()) {
      size = b.size();
      helper = a;
    } else {
      size = a.size();
      helper = b;
    }
    for (int i = 0; i < size; i++) {
      answer.add(a.get(i));
      answer.add(b.get(i));
    }
    for (int i = size; i < helper.size(); i++) {
      answer.add(helper.get(i));
    }
    return answer;
  }

  public static void main(String[]args){
    SuperArray words = new SuperArray();
    SuperArray a = new SuperArray();
    SuperArray b = new SuperArray();
    //grouped to save vertical space
    words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");
    words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
    words.add("una");    words.add("ebi");     words.add("toro");

    a.add("una"); b.add("una");
    a.add("kani");  b.add("kani");
    a.add("una"); b.add("una");
    a.add("toro"); b.add("toro");

    System.out.println(words);
    removeDuplicates(words);
    System.out.println(words);

    System.out.println(a);
    a.add("toro"); b.add("toro");
    System.out.println(a);

    System.out.println(findOverlap(words, a));
    System.out.println(b.indexOf("toro"));
    System.out.println(b.lastIndexOf("toro"));
    System.out.println(a.equals(b));
    System.out.println(b);
    System.out.println(a);
    System.out.println(zip(words, a));
  }
}
