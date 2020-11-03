public class SuperArray {
  //instance variables
  private String [] data;
  private int size;
  //constructor
  public SuperArray() {
    data = new String[10];
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
  private void resize() {
    String[] larger = new String[data.length + 2];
    for (int i = 0; i < size; i++) {
      larger[i] = data[i];
    }
    data = larger;
  }
}
