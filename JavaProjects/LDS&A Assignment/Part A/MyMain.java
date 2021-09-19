
/**
* The main class of our project.<br>. 
*/
public class MyMain {

	//-------------------------------------
	//	testMyQueue 
	//-------------------------------------	
	/** 
	* This function test the MyQueue interface and its static implementation.<br>
	*/
	public static void testMyStaticQueue() {
		
		//-------------------------------------
		//	1. We create myQueue 
		//-------------------------------------
		MyQueue m;
		//m = my_create_empty(); //--> We cannot create a new myQueue using explicitly my_create_empty()
		m = new MyStaticQueue(3); //--> Instead we choose to follow the implementation class. 

		//-------------------------------------
		//	2. isEmpty 
		//-------------------------------------
		System.out.println("Is it empty: " + m.isEmpty()); //--> The current length is 0 as myQueue is created initially empty
				
		//-------------------------------------
		//	3. Add three elements 
		//-------------------------------------
		m.enqueue(3); 
		m.enqueue(4);		
		m.enqueue(5); 
		m.enqueue(6); //--> Fails, as myQueue is already full
		
		//-------------------------------------
		//	4. print & isEmpty 
		//-------------------------------------
		System.out.print("Queue=") ;
		m.print();  //--> m : [5, 4, 3]
		System.out.println("") ;
		System.out.println("Is it empty: " + m.isEmpty()); //--> The current length is 3
		
		//-------------------------------------
		//	5. Get and remove the front item in myQueue 
		//-------------------------------------	
		System.out.println("Item that was at the front of the queue = " + m.dequeue()); 

		System.out.println("Item that is at the rear of the queue = " + m.rear()); 
		
		System.out.println("Item that is at the front of the queue = " + m.front()); 
		m.dequeue();
		System.out.println("Item that was at the front of the queue = " + m.dequeue()); 
		
		//-------------------------------------
		//	6. print  
		//-------------------------------------
		System.out.print("Queue=") ;
		m.print();  //--> m : [ ]
		System.out.println("") ;
		
	
	}

	//-------------------------------------
	//	testMyDynamicQueue 
	//-------------------------------------	
	/** 
	* This function test the MyQueue interface and its dynamic implementation.<br>
	*/
	public static void testMyDynamicQueue() {
		
		//-------------------------------------
		//	1. We create myQueue 
		//-------------------------------------
		MyQueue m;
		m = new MyDynamicQueue(); //--> Instead we choose to follow the dynamic implementation class. 
		//-------------------------------------
		//	2. isEmpty 
		//-------------------------------------
		System.out.println("Is it empty: " + m.isEmpty()); //--> The current length is 0 as myQueue is created initially empty
				
		//-------------------------------------
		//	3. Add elements 
		//-------------------------------------
		m.enqueue(3); 
		m.enqueue(4);		
		m.enqueue(5); 
		m.enqueue(6); 
		
		//-------------------------------------
		//	4. print & isEmpty 
		//-------------------------------------
		System.out.print("Queue=") ;
		m.print();  
		System.out.println("") ;
		System.out.println("Is it empty: " + m.isEmpty()); //--> The current length is 4
		
		//-------------------------------------
		//	5. Get and remove the items in myQueue 
		//-------------------------------------	
		System.out.println("Item that is in the front of the queue = " + m.front()); 
		m.dequeue();
		System.out.println("Item that is in the back of the queue = " + m.rear()); 
		
		System.out.println("Item that was in the front of the queue = " + m.dequeue()); 
		
		System.out.println("Item that was in the front of the queue = " + m.dequeue());
		
		System.out.println("Item that was in the front of the queue = " + m.dequeue()); 
		System.out.println("Item that was in the front of the queue = " + m.dequeue());
		//-------------------------------------
		//	6. print  
		//-------------------------------------
		System.out.print("Queue=") ;
		m.print();  //--> m : [ ]
		System.out.println("") ;
		
	
	}
//-------------------------------------
	//	testMyDynamicQueue 
	//-------------------------------------	
	/** 
	* This function test the MyQueue interface and its priority implementation.<br>
	*/
	public static void testMyPriority6Queue() {
		
		//-------------------------------------
		//	1. We create myQueue 
		//-------------------------------------
		MyQueue m;
		m = new MyPriorityQueue(); //--> Instead we choose to follow the dynamic implementation class. 
		//-------------------------------------
		//	2. isEmpty 
		//-------------------------------------
		System.out.println("Is it empty: " + m.isEmpty()); //--> The current length is 0 as myQueue is created initially empty
				
		//-------------------------------------
		//	3. Add elements 
		//-------------------------------------
		m.enqueue(63); 
		m.enqueue(14);		
		m.enqueue(59); 
		m.enqueue(6);  //[59,63,6,14]
		
		//-------------------------------------
		//	4. print & isEmpty 
		//-------------------------------------
		System.out.print("Queue=") ;
		m.print();  
		System.out.println("") ;
		System.out.println("Is it empty: " + m.isEmpty()); //--> The current length is 4
		
		//-------------------------------------
		//	5. Get and remove the items in myQueue 
		//-------------------------------------	
		System.out.println("Item that is in the front of the queue = " + m.front()); 
		m.dequeue();
		System.out.println("Item that is in the back of the queue = " + m.rear()); 
		
		System.out.println("Item that was in the front of the queue = " + m.dequeue()); 
		
		System.out.println("Item that was in the front of the queue = " + m.dequeue());
		
		System.out.println("Item that was in the front of the queue = " + m.dequeue()); 
		System.out.println("Item that was in the front of the queue = " + m.dequeue());
		//-------------------------------------
		//	6. print  
		//-------------------------------------
		System.out.print("Queue=") ;
		m.print();  //
		System.out.println("") ;
		
	
	}	
	//-------------------------------------
	//	main 
	//-------------------------------------		
	/**
	 * Main Method:<br> 
	 * Calls to the function testMyQueue to test MyQueue and its implementation.<br>
	 * @param args: We will run the program parameter free, so do not worry about it. 
	 */	
	public static void main(String[] args) {
		//1. We call to the functions to test the static and dynamic implementations
		testMyStaticQueue();
		testMyDynamicQueue();
		testMyPriorityQueue();
	}

}
