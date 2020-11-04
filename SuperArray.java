public class SuperArray {
  //instance variables
  private String [] data;
  private int size;
  //constructor
  public SuperArray() {
    data = new String[10];
    size = 0;
  }
  public SuperArray(int initialCapacity) {
    data = new String[initialCapacity];
    size = 0;
  }
  //methods
  public int size() {
    return size;
  }

  public boolean add(String element) {
    if (size < data.length) {
      data[size] = element;
    } else {
      resize();
      data[size] = element;
    }
    size++;
    return true;
  }

  public String get(int index) {
    return data[index];
  }

  public String set(int index, String element) {
    String replaced = data[index];
    data[index] = element;
    return replaced;
  }
  //new methods!
  public boolean isEmpty() {
    return (size == 0);
  }

  public void clear () {
    int cap = data.length;
    data = new String[cap];
    size = 0;
  }

  public String toString() {
    if (size == 0) {
      return "[]";
    }
    String answer = "[";
    for (int i = 0; i < size - 1; i++) {
      answer += data[i] + ", ";
    }
    answer += data[size - 1] + "]";
    return answer;
  }

  public boolean contains(String s) {
    int len = s.length();
    String whole = data.toString();
    for (int i = 0; i < len; i++) {
      if (whole.substring(i, i + len).equals(s)) {
        return true;
      }
    }
    return false;
  }

  private void resize() {
    String[] larger = new String[data.length + 2];
    for (int i = 0; i < size; i++) {
      larger[i] = data[i];
    }
    data = larger;
  }
}
