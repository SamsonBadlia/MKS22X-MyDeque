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
    int i = start, j = 0;

    if(size !=0){
      if (end >= start) {
        while( i <= end ){
          data[j] = newArr[i];
          i++; j++;
        }
      }
      else{
        while(end >= i){
          data[j] = newArr[i];
          i++; j++;
          if(i == data.length) i = 0;
        }
      }
    }

  }

  public String toString(){
    String s = "{";

    for(int i = start; i < data.length; i++){
      if(data[i] != null){
        s += data[i];
        if(i != end) s += " ";
      }
    }

    for(int i = 0; i < start; i++){
      if(data[i] != null){
        s += data[i];
        if(i != end) s += " ";
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
    start--;
    size++;
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    if (size == data.length) resize();

    if (end == 0 && start == 0) start--;
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

}
