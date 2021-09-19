
/**
* ADT myqueue: Public Part<br>. 
* The interface includes all the operations available to a myqueue user<br>
*/
public interface MyQueue {

	//-------------------------------------------------------------------
	// Create an empty myQueue: my_create_empty
	//-------------------------------------------------------------------
	//public myqueue my_create_empty(); --> Java does not support constructors in interfaces
		
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myqueue is empty: isEmpty
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete myqueue, it returns whether it is empty or not.<br>
	 * @return: Whether myqueue is empty or not.
	 */	
	public boolean isEmpty();
	
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get the element at the top of myqueue and removes it: dequeue
	//-------------------------------------------------------------------
	/**
	 * Given a concrete myqueue, it returns and removes the item in the top of the queue (if any).<br>
	 * @return: element from the top of myqueue (ERROR if there are no items in myqueue).
	 */	
	public int dequeue();
		

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to the top of myqueue: push 
	//-------------------------------------------------------------------
	/**
	* Given a concrete myqueue, add an item to the back of the queue.<br>
	* @param element: New item to be added to myqueue.	 
    */	

	public void enqueue(int element);
	
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> get the item at the top of myqueue: front
	//-------------------------------------------------------------------
	/**
	 * Given a concrete myqueue, get the item at the top of the queue.<br>
	 * 
	 */	
	public int front();
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> get the item at the back of myqueue: rear
	//-------------------------------------------------------------------
	/**
	* Given a concrete myqueue, get the item at the back of the queue.<br>
	* 
	*/	
	public int rear();
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> prints all the elements from myqueue: print
	//-------------------------------------------------------------------
	/**
	 * Given a concrete myqueue, prints all the elements (if any).<br>
	 * 
	 */	
	public void print();

}
