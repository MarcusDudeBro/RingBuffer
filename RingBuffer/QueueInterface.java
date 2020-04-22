package RingBuffer;
/**
 * Queue Interface
 * CS 108 Spring 2020
 * @author Marcus Casillas
 * @date 22 April 2020
 */
 
public interface QueueInterface<E> { 
   
   /**
    * The enQueue method inserts an element
    * in the Queue and return true, if successful
    * The element is always entered at the end
    * of the queue.
    * 
    * @param Integer value to be inserted
    * @return boolean true, if successful, false otherwise
    */
      public boolean enQueue(E item);
    
    /**
     * The deQueue deletes an element in the
     * Queue, and returns the element.
     * The element is always removed from the
     * front of the queue. 
     * 
     * @return Integer value of the removed element
     */
      public E deQueue();
    
    /**
     * The peek method returns the head (or the
     * first element) of the Queue
     * 
     * @return Integer value of the first element
     */ 
      public E peek();
     
     /**
      * The isEmpty() method returns true if the
      * Queue is empty, false otherwise
      * 
      * @return boolean true, if empty, false otherwise
      */
      public boolean isEmpty();
}
