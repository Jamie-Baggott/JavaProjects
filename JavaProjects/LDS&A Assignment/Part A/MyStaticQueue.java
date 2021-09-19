//Name: Jamie Baggott
//Student Number: R00149982 


import javax.xml.validation.ValidatorHandler;

/**
* ADT MyQueue: Private Part<br>. 
* The class implements all the operations available in MyQueue<br>
*/
public class MyStaticQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private int items[]; 
	private int numItems;
	private int maxItems;

	//-------------------------------------------------------------------
	//-------------------------------------------------------------------	
	//public myQueue myCreateEmpty(){}
	
	/**
	 * The constructor creates 1 instance (1 object) of the class MyStaticQueue<br>
	 * @param m: The maximum number of items MyQueue can contain.
	 */	 
	public MyStaticQueue(int m){//TO-COMPLETE
		// NOTE: Make sure m is not negative before setting maxItems attribute.
		if (m >= 0){
			this.maxItems = m;
		} else{
			this.maxItems = 0;
			System.out.println("m was negative so mapping m to 0");
		}
		this.numItems = 0;
		this.items = new int[this.maxItems];
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyQueue, it returns whether it is empty or not.<br>
	 * @return: Whether MyQueue is empty or not.
	 */	
	public boolean isEmpty(){//TO-COMPLETE 
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = true;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		// NOTE: Checking if the number of items is not 0. If so then the list isnt empty
		if (this.numItems != 0){
			res = false;
		}
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get and remove first element from top of MyQueue: dequeue
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyQueue, it returns element at the top of the queue (if any).<br>
	 * @return: Head element from MyQueue (ERROR if there are no items in MyQueue).
	 */	
	public int dequeue(){//TO-COMPLETE 
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		//NOTE: If the list isnt empty set result to the last item in the list, which is the one at the top of the queue
		if (!this.isEmpty()){
			res = this.items[this.numItems -1];
			//NOTE: No need to actually remove the item because we are keeping track of the size.
			this.numItems -= 1;
		} else {
			System.out.println("Error. No items left in the queue");
		}

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

		
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to the top of MyQueue: enqueue
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyQueue, add an item to the back of the queue.<br>
	 * @param element: New item to be added to MyQueue.	 
	 */	
	public void enqueue(int element){//TO-COMPLETE 
		//-----------------------------
		//SET OF OPS
		//-----------------------------
	
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

		if (this.numItems >= this.maxItems){
			System.out.println("Error queue is full");
		} else{
			// NOTE: Add the item to the back of the queue, but first we need to shuffle everything to the right
			for (int i=this.maxItems-1; i>0; i--){
				this.items[i] = this.items[i-1];
			}
			this.items[0] = element;
			this.numItems ++;
		}

	}
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> get the item at the top of myqueue: front
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyQueue, get the item at the top of the queue..<br>
	 * @return: item at top of  MyQueue.	 
	 */	
	public int front(){//TO-COMPLETE 
		//-----------------------------
		//SET OF OPS
		//-----------------------------
	
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		int result = -1;
		if (this.numItems != 0){
			// NOTE: Get the item at the front of the queue
			result = this.items[this.numItems -1];
		} else {
			System.out.println("Error. Queue is empty");
		}
		return result;
	}
		
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> get the item at the top of myqueue: front
	//-------------------------------------------------------------------
	/**
	* Given a concrete MyQueue, get the item at the back of the queue..<br>
	* @return: item at back of  MyQueue.	 
	*/	
	public int rear(){//TO-COMPLETE 
		//-----------------------------
		//SET OF OPS
		//-----------------------------
			
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		int result = -1;
		if (this.numItems != 0){
			// NOTE: Get the item at the front of the queue
			result = this.items[0];
		} else {
			System.out.println("Error. Queue is empty");
		}
		return result;
	}
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> prints all the elements from MyQueue: print
	//-------------------------------------------------------------------
	/** 
	 * Given a concrete MyQueue, prints all the elements (if any).<br>
	 * 
	 */	
	public void print(){//TO-COMPLETE 
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		int result = -1;
		if (this.numItems != 0){
			// NOTE: Loop through the list and print each item
			for (int i=0; i<this.numItems; i++){
				System.out.print(this.items[i]);
				System.out.print(", ");
			}
			System.out.println();
		} else {
			System.out.println("[]");
		}
	}
	
}
