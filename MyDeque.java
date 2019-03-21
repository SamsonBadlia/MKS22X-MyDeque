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

  public void resize(){
    //E newArr  = new E[ data.length * 2 + 1 ];
    //for (int i )
  }

  public String toString(){
    String s = "{";
    if (start < end){
      for (int i = start; i < end; i++){
        if (data[i] != null) s += data[i] + " ";
      }
    } else{
      for (int i = end; i < start; i++){
        if (data[i] != null) s += data[i] + " ";
      }
    }
    s += "}";
    return s;
  }

  public void addFirst(E element){
    if (start == data.length){
      start = 0;

    }
  }

  public void addLast(E element){

  }

  public E removeFirst(){
    E temp = data[start];
    if (end < start) start++;
    else start--;
    return temp;
  }

  public E removeLast(){
    E temp = data[end];
    if (end < start) end++;
    else end--;
    return temp;
  }

  public E getFirst(){
    if (data[start] != null) return data[start];
  }

  public E getLast(){
    if (data[end] != null) return data[end];
  }

  public static void main(String[] args) {
    MyDeque<Integer> m = new MyDeque<Integer>();
    System.out.println(m);
  }



}
