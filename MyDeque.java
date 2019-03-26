import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start = 0;
  private int end = 0;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[]) new Object[10];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[]) new Object[initialCapacity];
  }

  public int size(){
    return this.size;
  }

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] newArr = data;
    data = (E[]) new Object[data.length * 2 + 1];
    if (start > end){
      for (int i = start; i < data.length; i++){
        newArr[i] = data[i];
      }
      for (int i = 0; i < end; i++){
        newArr[i] = data[i];
      }
    } else {
      for (int i = start; i < end; i++){
        newArr[i] = data[i];
      }
    }
  }

  public String toString(){
    String s = "{";
    if (start < end){
      for (int i = start; i < end; i++){
        if (i != end - 1) s += data[i] + " ";
        else s += data[i];
      }
    }
    else{
      for (int i = start; i < data.length; i++){
        if (i != data.length - 1 && data[i] != null) s += data[i] + " ";
        else if (data[i] != null) s += data[i];
      }
      for (int i = 0; i < end; i++){
        if (i != data.length - 1&& data[i] != null) s += data[i] + " ";
        else if (data[i] != null)   s += data[i];
      }
    }
    s += "}";
    return s;
  }

  public void addFirst(E element) {
    if (element == null) throw new NullPointerException();
    if (size == data.length) resize();

    if (end == 0 && start == 0) end++;
    if (start < 0) start = data.length - 1;

    if (data[start] != null) start--;
    data[start] = element;
    start++;
    size++;
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    if (size == data.length) resize();

    if (end == 0 && start == 0) start++;
    if (end >= data.length) end = 0;

    if (data[end] != null) end++;
    data[end] = element;
    end++;
    size++;
  }

  public E removeFirst(){
    if (size == 0) throw new NoSuchElementException();

    int index;
    if (start + 1 >= data.length) index = 0;
    else index = start + 1;

    E temp = data[index];
    data[start] = null;
    start = index;
    size--;
    return temp;
  }

  public E removeLast() {
    if (size == 0) throw new NoSuchElementException();

    int index;
    if (end - 1 < 0) index = data.length - 1;
    else index = end - 1;

    E temp = data[index];
    data[index] = null;
    end = index;
    size--;
    return temp;
  }

  public E getFirst(){
    if (size == 0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast(){
    if (size == 0) throw new NoSuchElementException();
    return data[end];
  }

  public String debugString() {
    String parts = "debug:\n";
    parts += Arrays.toString(data);
    parts += String.format("\nStart index: %d\nEnd index: %d", start, end);
    return parts;
  }

}
