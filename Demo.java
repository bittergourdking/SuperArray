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

  /* testing
    public static SuperArray findOverlap(SuperArray a, SuperArray b) {
    SuperArray answer = new SuperArray();
    String checker = "";
    for (int i = 0; i < a.size(); i++) {
      if (answer.size() != 0) {
        for (int k = 0; k < answer.size(); k++) {
          if (a.get(i).equals(answer.get(k))) {
            break;
          } else {
            checker = a.get(i);
            for (int j = 0; j < b.size(); j++) {
              if (b.get(j).equals(checker)) {
                answer.add(b.get(j));
                break;
              }
            }
          }
        }
      }
    }
    return answer;
  }
  */

  public static SuperArray findOverlap(SuperArray a, SuperArray b) {
    SuperArray answer = new SuperArray();
    SuperArray aHelper = a; SuperArray bHelper = b;
    removeDuplicates(aHelper);  removeDuplicates(bHelper);
    String checker = "";
    for (int i = 0; i < aHelper.size(); i++) {
      checker = a.get(i);
      for (int j = 0; j < bHelper.size(); j++) {
        if (bHelper.get(j).equals(checker)) {
          answer.add(bHelper.get(j));
        }
      }
    }
    return answer;
  }


  public static void main(String[]args){
    SuperArray words = new SuperArray();
    SuperArray a = new SuperArray();
    //grouped to save vertical space
    words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");
    words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
    words.add("una");    words.add("ebi");     words.add("toro");

    a.add("una");
    a.add("kani");
    a.add("una");
    a.add("toro");

    System.out.println(words);
    removeDuplicates(words);
    System.out.println(words);
    System.out.println(a);
    System.out.println(findOverlap(words, a));
  }
}
