package DataStructure;

import java.util.ArrayList;

//for custom type T, the class need to implements Comparable<T>
public class PriorityQueue<T extends Comparable> {

  protected ArrayList<T> storedValues;

  public PriorityQueue() {
    storedValues = new ArrayList(); //init the array
    storedValues.add(null); //add dummy to make array index start from 1
  }

  //return the size of the Priority Queue
  public int count() {
    return storedValues.size() - 1;
  }

  //return the top of the Priority Queue
  public T peek() {
    if (count() == 0) {
      return null;
    } else {
      return storedValues.get(1);
    }
  }

  //add a new data to the Priority Queue
  public void add(T value) {
    storedValues.add(value); //add
    bubbleUp(); //bubble up from the last index to preserve the heap property
  }

  //return and pop the top of the Priority Queue
  public T pop() {
    if (count() == 0) {
      return null;
    } else if (count() == 1) {
      return storedValues.remove(1);
    } else {
      T top = storedValues.get(1);
      swap(1, storedValues.size() - 1); //swap the lastElement with the firstElement
      storedValues.remove(storedValues.size() - 1); //delete the last index
      bubbleDown();
      return top;
    }
  }

  private void bubbleUp() {
    int index = storedValues.size() - 1;
    while (isParentBigger(index)) {
      swap(index, index / 2);
      index = index / 2;
    }
  }

  private void bubbleDown() {
    int index = 1; //start at root node
    while (true) {
      int leftChildIndex = index * 2;
      if (leftChildIndex < storedValues.size()) {
        int smallerChildIndex = leftChildIndex;
        if (leftChildIndex + 1 < storedValues.size()) //if there is a right child
        {
          T leftChild = storedValues.get(leftChildIndex);
          T rightChild = storedValues.get(leftChildIndex + 1);

          if (leftChild.compareTo(rightChild) > 0) {
            smallerChildIndex = leftChildIndex + 1;
          }
        }
        if (storedValues.get(smallerChildIndex).compareTo(storedValues.get(index)) < 0) {
          swap(index, smallerChildIndex);
        } else {
          break;
        }
        index = smallerChildIndex;
      } else {
        break;
      }
    }
  }

  private boolean isParentBigger(int index) {
    if (index == 1) {
      return false; //no parent
    } else {
      return storedValues.get(index / 2).compareTo(storedValues.get(index)) > 0;
    }
  }

  private void swap(int index1, int index2) {
    T temp = storedValues.get(index1);
    storedValues.set(index1, storedValues.get(index2));
    storedValues.set(index2, temp);
  }
}

