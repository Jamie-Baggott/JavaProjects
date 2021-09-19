//Name: Jamie Baggott
//Student Number: R00149982 


/**
* ADT MyQueue: Private Part<br>. 
* The class implements all the operations available in MyQueue<br>
*/
public class MyPriorityQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	// NOTE: Create a variable to keep track of the head of our linked list (LL)
	MyNode head;
	int numItems;
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	//public myQueue myCreateEmpty(){}
	
	public MyPriorityQueue(){//TO-COMPLETE
		// NOTE: Init the two attributes
		this.head = new MyNode(-1, null);
		this.numItems = 0;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	

	public boolean isEmpty(){//TO-COMPLETE 
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = true;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
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

	public int dequeue(){//TO-COMPLETE 
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		// NOTE: Make sure there is some stuff in the LL
		if (this.numItems >0) {
			MyNode node = this.head;
			MyNode previous = null;

			// NOTE: Loop through the list until we get to the last item
			while (node.getNext() != null) {
				previous = node;
				node = node.getNext();

			}
			// NOTE: Set the second last nodes, next to null --> Cut off the last node
			res = node.getInfo();
			previous.setNext(null);

			// NOTE: Decrement the number of items
			this.numItems --;
		} else {
			System.out.println("Error queue is empty");
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
	// Basic Operation (Partial) --> Add element to the MyQueue based on its priority class: enqueue
	//-------------------------------------------------------------------
	
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

		// NOTE: Create the new element
		MyNode nodeToInsert = new MyNode(element, null);

		// NOTE: See if the list is empty if so add the node as the first item
		if (this.head.getNext() == null){
			this.head.setNext(nodeToInsert);
		} else{

			MyNode node = this.head.getNext();
			MyNode previous = this.head;
			// NOTE: Loop until we find the correct priority position or until we get to the end of the list, then add the item.
			while (this.getNodeClass(nodeToInsert) < this.getNodeClass(node) && node.getNext() != null){
				previous = node;
				node = node.getNext();
			}

			nodeToInsert.setNext(node.getNext());
			node.setNext(nodeToInsert);

		}
		this.numItems ++;

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
		// NOTE: See if there is any item left, if not error, if so then return the item
		int res = -1;
		if (this.numItems == 0){
			System.out.println("Error, queue empty");
		} else {
			res = this.head.getNext().getInfo();
		}

		return res;
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
		int res = -1;
		if (this.numItems == 0){
			System.out.println("Error, queue empty");
		} else {
			// NOTE: Loop to the last item and then set res to the last items value
			MyNode node = this.head;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			res = node.getInfo();
		}

		return res;
	}
	
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> prints all the elements from MyQueue: print
	//-------------------------------------------------------------------

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
		if (this.numItems == 0){
			System.out.println("[]");
		} else {
			// NOTE: Loop through printing each item
			MyNode node = this.head;
			while (node.getNext() != null) {
				node = node.getNext();
				System.out.print(node.getInfo());
				System.out.print(",");

			}
		}

	}

	private int getNodeClass(MyNode node){
		// NOTE: Private method to work out whether a given node should be in class 1 or 2
		int nodeClass;
		if (node.getInfo() >= 50){
			nodeClass = 2;
		} else {
			nodeClass = 1;
		}
		return nodeClass;
	}
	
	
}
