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
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("initialCapacity " + initialCapacity + " cannot be negative");
    }
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
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("index " + index + " is not within bounds 0 - " + size());
    }
    return data[index];
  }

  public String set(int index, String element) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("index " + index + " is not within bounds 0 - " + size());
    }
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
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("index " + index + " is not within bounds 0 - " + (size() - 1));
    }
    if (size == data.length) {
      resize();
    }
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = element;
    size++;
  }

  public String remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("index " + index + " is not within bounds 0 - " + size());
    }
    String answer = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    size--;
    data[size] = null;
    return answer;
  }

  public int indexOf(String s) {
    int answer = 0;
    if (contains(s)) {
      for (int i = 0; i < size; i++) {
        if (data[i].equals(s)) {
          answer = i;
          i = size;
        }
      }
      return answer;
    }
    return -1;
  }

  public int lastIndexOf(String value) {
    int answer = 0;
    if (contains(value)) {
      for (int i = size - 1; i > -1; i--) {
        if (data[i].equals(value)) {
          answer = i;
          i = -1;
        }
      }
      return answer;
    }
    return -1;
  }

  public String[] toArray() {
    String[] answer = new String[size];
    for (int i = 0; i < size; i++) {
      answer[i] = data[i];
    }
    return answer;
  }

  public boolean equals(SuperArray other) {
    if (size > other.size() || size < other.size()) {
      return false;
    }
    for (int i = 0; i < size; i++) {
      if (data[i].equals(other.get(i))) {
      } else {
        return false;
      }
    }
    return true;
  }

  private void resize() {
    String[] larger = new String[(data.length * 2) + 1];
    for (int i = 0; i < size; i++) {
      larger[i] = data[i];
    }
    data = larger;
  }
}
