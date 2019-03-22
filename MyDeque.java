import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 0; end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start = 0; end = 0;
  }

  public int size(){
    return this.size;
  }

  @SuppressWarnings("unchecked")
  public void resize() {
      Object[] newArr = new Object[data.length * 2 + 1];
      int newArrIndex = 0;
      if (start >= end - 1) {
          for (int i = data.length - 1; i >= start + 1; i--) {
              newArr[newArrIndex] = data[i];
              newArrIndex++;
          }
          for (int i = 0; i < end; i++) {
              newArr[newArrIndex] = data[i];
              newArrIndex++;
          }
      } else {
          for (int i = start; i < end; i++) {
              newArr[newArrIndex] = data[i];
              newArrIndex++;
          }
      }
      data = (E[]) newArr;
      start = 0;
      end = size;
  }

  public String toString(){
    String s = "{";
    if (start < end){
      for (int i = start; i < end; i++){
        if (data[i] != null) s += data[i] + " ";
      }
    } else{
      for (int i = end; i < start; i++){
        if (data[i] != null) s += data[i] + " , ";
      }
    }
    s += "}";
    return s;
  }

  //has IndexOutOfBounds MUST FIX ASAP
  public void addFirst(E element){
    if (element == null) throw new NullPointerException();
    if (size == data.length) resize();
    if (start < 0) start = data.length - 1;
    if (data[start] == null){
      if (start == end) end++;
      data[start] = element;
      start++;
      size++;
    }
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    if (size == data.length) resize();
    if (data[end] != null) end++;
    if (end >= data.length) end = 0;
    data[end] = element;
    end++;
    size++;
  }

  public E removeFirst(){
    if (start <= 0 || start >= data.length) throw new NoSuchElementException();
    E temp = data[start];
    data[start] = null;
    start--;
    return temp;
  }

  public E removeLast(){
    if (end <= 0 || end >= data.length) throw new NoSuchElementException();
    E temp = data[end];
    end--;
    data[end] = null;
    return temp;
  }

  public E getFirst(){
    if (start <= 0 || start >= data.length) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast(){
    if (end <= 0 || end >= data.length) throw new NoSuchElementException();
    return data[end];
  }

  //System.out.println();
  public static void main(String[] args) {
    MyDeque<Integer> m = new MyDeque<Integer>();

    System.out.println("Should be {} : ");
    System.out.println(m);
    System.out.println();
    System.out.println();

    System.out.println("Adding to end : ");
    m.addLast(1);
    System.out.println("{1} :");
    System.out.println(m);
    m.addLast(23);
    System.out.println("{1,23} : ");
    System.out.println(m);

    System.out.println("Adding to start : ");
    m.addFirst(5);
    System.out.println("{5,1,23} : ");
    System.out.println(m);
    m.addFirst(9);
    System.out.println("{9,5,1,23} : ");
    System.out.println(m);


  }



}
