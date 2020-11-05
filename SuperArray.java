public class SuperArray {
  //instance variables
  private String [] data;
  private int size;
  //constructors
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
    for (int i = 0; i < size; i++) {
      if (data[i].equals(s)) {
        return true;
      }
    }
    return false;
  }

  public void add(int index, String element) {
    if (size == data.length - 1) {
      resize();
    }
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = element;
    size++;
  }

  public String remove(int index) {
    String answer = data[index];
    data[index] = null;
    for (int i = index; i < size; i++) {
      data[i] = data[i + 1];
    }
    return answer;
  }

  public int indexOf(String s) {
    int answer = 0;
    for (int i = 0; i < size; i++) {
      if (data[i].equals(s)) {
        answer = i;
      }
    }
    return answer;
  }

  public String[] toArray() {
    String[] answer = new String[size];
    for (int i = 0; i < size; i++) {
      answer[i] = data[i];
    }
    return answer;
  }

  private void resize() {
    String[] larger = new String[(data.length * 2) + 1];
    for (int i = 0; i < size; i++) {
      larger[i] = data[i];
    }
    data = larger;
  }
}
