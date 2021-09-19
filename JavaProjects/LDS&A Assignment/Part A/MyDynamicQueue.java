//Name: Jamie Baggott
//Student Number: R00149982 


import javax.annotation.processing.SupportedSourceVersion;

/**
* ADT MyQueue: Private Part<br>. 
* The class implements all the operations available in MyQueue<br>
*/
public class MyDynamicQueue implements MyQueue {
// NOTE: Comments here are the same as the MyPriortyQueue file except for line 113


	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	MyNode head;
	int numItems;
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	//public myQueue myCreateEmpty(){}
	
	public MyDynamicQueue(){//TO-COMPLETE
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
		if (this.numItems >0) {
			MyNode node = this.head;
			MyNode previous = null;
			while (node.getNext() != null) {
				previous = node;
				node = node.getNext();

			}
			res = node.getInfo();
			previous.setNext(null);
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
	// Basic Operation (Partial) --> Add element to the top of MyQueue: enqueue
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
		// NOTE: Get the first head and its next element. Set the heads next to the new node, set the new nodes next to the old first
		MyNode oldFirst = this.head.getNext();
		this.head.setNext(
				new MyNode(element, oldFirst)
		);
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
			MyNode node = this.head;
			while (node.getNext() != null) {
				node = node.getNext();
				System.out.print(node.getInfo());
				System.out.print(",");

			}
		}

	}
	
	
}
