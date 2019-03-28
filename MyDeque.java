import java.util.*;

public class MyDeque<E>{

  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[]) new Object[10];
    end = 0; size = 10; start = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    E[] d = (E[]) new Object[initialCapacity];
    data = d;
    size = initialCapacity;
    end = 0; start = 0;
  }

  public int size(){
    if (end >= start) return end - start;
    else return (size - start) + end - 1;
  }

  public String toString(){
    if (start == end){
      return "{}";
    }

    String s = "{";

    if (end < start){
      for (int i = start; i < size; i++){
        s += data[i] + " ";
      }
      for (int i=0; i < end; i++){
        s += data[i] + " ";
      }
    }

    else {
      for (int i = start; i < end; i++){
        s += data[i] + " ";
      }
    }

    s += "}";
    return s;
  }

  private void resize(){
   @SuppressWarnings("unchecked")
   E[] newArr = (E[])new Object[size * 2 + 1];
   int idx = 0;

   if (end <= start){
     for (int i = start; i < size; i++){
       newArr[idx] = data[i];
       idx++;
     }
     for (int i = 0; i < end; i++){
       newArr[idx] = data[i];
       idx++;
     }
   }

   else {
     for (int i = start; i < end; i++){
       newArr[idx] = data[i];
       idx++;
     }
   }

   start = 0; end = size();
   size = size * 2;
   data = newArr;
 }

//adding Functions (add to front and end of stack/queue)

  public void addFirst(E element){
    nullCheck(element);

    if (size() == 0){
      end++;
      data[end-1] = element;
    }

    else {
      isFull();
      if (start == 0){
        for (int i = end; i >= 1; i--){
          data[i] = data[i-1];
        }
        data[0] = null;
        start++;
        end++;
      }
      start--;
      data[start] = element;
    }

  }

  public void addLast(E element){
    nullCheck(element);

    if (size() == size) resize();
    if (end == size){
      data[0] = element;
      end = 1;
    }
    else {
      data[end] = element;
      end++;
    }
  }

//removing Functions (remove and return the front or end of stack/queue)

  public E removeFirst(){
    isEmpty();

    E temp = data[start];
    data[start] = null;

    if (start == end - 1){
      start = 0;
      end = 0;
      return temp;
    }

    if (start < size - 1) start++;
    else start = 0;
    return temp;
  }

  public E removeLast(){
    isEmpty();

    E temp = data[end - 1];
    end--;
    return temp;
  }

//get Functions (return the element at the front or end of the stack/queue)

  public E getFirst(){
    elementException();

    return data[start];
  }

  public E getLast(){
    elementException();

    return data[end - 1];
  }


//helper methods to assist with resizing and errors

  private void nullCheck(E element){
    if (element == null) throw new NullPointerException();
  }

  private void isFull(){
    if (end == size || end == start) resize();
  }

  private void isEmpty(){
    if (size() == 0) throw new NoSuchElementException();
  }

  private void elementException(){
    if (start == end) throw new NoSuchElementException();
  }

}
