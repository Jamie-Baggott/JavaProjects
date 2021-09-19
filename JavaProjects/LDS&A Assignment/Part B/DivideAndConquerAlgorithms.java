//Name: Jamie Baggott
//Student Number: R00149982


/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
	
	//-------------------------------------------------------------------
		// 0. iterativeDisplayElements --> Displays all elements of a MyList 
		//-------------------------------------------------------------------	
		/**
		 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
		 * @param m: The MyList we want to display its elements.	  
		 */	
		public void iterativeDisplayElements(MyList<Integer> m){
			//-----------------------------
			//SET OF OPS
			//-----------------------------

			//-----------------------------
			// I. SCENARIO IDENTIFICATION
			//-----------------------------
			int scenario = 0; 
			
			//Rule 1. MyList is empty
			if (m.length() == 0) 
				scenario = 1;
			//Rule 2. MyList is non-empty
			else
				scenario = 2;

			//-----------------------------
			// II. SCENARIO IMPLEMENTATION 
			//-----------------------------
			switch(scenario){	
					
			//Rule 1. MyList is empty
			case 1: 
				//1. We print the empty message
				System.out.println("Empty MyList");
				
				break;
				
			//Rule 2. MyList is non-empty
			case 2: 
				//1. We print the initial message
				int size = m.length();
				System.out.println("MyList Contains the following " + size + " items: ");
				
				//2. We traverse the items
				for (int i = 0; i < size; i++)
					System.out.println("Item " + i + ": " + m.getElement(i));
				
				break;
		
			}
			
		}	
	//-------------------------------------------------------------------
	// 1. getEven --> Finds the even numbers in MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function finds the even number in m. 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: A new MyList containing only the even numbers present in m	  
	 */	
	public MyList<Integer> getEven(MyList<Integer> m){
		// NOTE: Check if the list passed is empty. If so then return an empty list (Used for when the user passes an empty arrary -> Stops recursion forever
		if (m.length() == 0){
			return new MyDynamicList<>();
		} else if (m.length() == 1){
			// NOTE: Check if the one item left is even, if it is then return the even item
			if (m.getElement(0) % 2 == 0){
				return m;
			} else {
				// NOTE: If the item is not even then return an empty list. This is because we do not want to include non-even items.
				return new MyDynamicList<>();
			}
		}

		// NOTE: Create a list for left and right. For this divide and concor craic, you basicly just keep splitting the list in two
		MyList<Integer> left = new MyDynamicList<>();
		MyList<Integer> right = new MyDynamicList<>();
		int rightIndex = 0;
		int leftIndex = 0;

		// NOTE: Split the list by putting the first half in the left and the second in the right.
		for (int i=0; i< m.length(); i++){
			if (i < m.length() / 2){
				left.addElement(leftIndex, m.getElement(i));
				leftIndex ++;
			} else {
				right.addElement(rightIndex, m.getElement(i));
				rightIndex ++;
			}

		}

		// NOTE: Recursivly call the get even on the left and the get even on the right.
		MyList<Integer> newLeft = this.getEven(left);
		MyList<Integer> newRight = this.getEven(right);

		// NOTE: Create a new list to return
		MyList<Integer> toReturn = new MyDynamicList<>();
		int d = 0;

		// NOTE: Add all the items from the left
		for (int i=0; i<newLeft.length(); i++){
			toReturn.addElement(i, newLeft.getElement(i));
			d++;
		}

		// NOTE: Add items from the right
		for (int i=0; i<newRight.length(); i++){
			toReturn.addElement(d, newRight.getElement(i));
			d++;
		}

		// NOTE: Return the list that now just contains even
		return toReturn;


	}

	//-------------------------------------------------------------------
	// 2. getProduct --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the product of all items in m.  
	 * @param m: The MyList we want to check.
	 * @return: The product value calculated.  
	 */	
	public int getProduct(MyList<Integer> m){
		int total = 0;

		// NOTE: Check if there is any item remianing. If not return 0; else return the item
		if (m.length() == 0){
			return 0;
		} else if (m.length() == 1){
			return m.getElement(0);
		}

		// NOTE: Same as get even method, split the list in two with half in the left and half in the right
		MyList<Integer> left = new MyDynamicList<>();
		MyList<Integer> right = new MyDynamicList<>();
		int rightIndex = 0;
		int leftIndex = 0;

		for (int i=0; i< m.length(); i++){
			if (i < m.length() / 2){
				left.addElement(leftIndex, m.getElement(i));
				leftIndex ++;
			} else {
				right.addElement(rightIndex, m.getElement(i));
				rightIndex ++;
			}

		}

		// NOTE: recursivly call the get product method on the left and right lists. Add the retured value to our total
		total = total + this.getProduct(left);
		total = total + this.getProduct(right);

		// NOTE: Return the total
		return total;
	}

	//-------------------------------------------------------------------
	// 3. isEqual --> Determines if two MyLists are identical  
	//-------------------------------------------------------------------	
	/**
	 * The function determines is m1 and m2 are identical.   
	 * @param m1, m2: The two MyLists we want to compare.
	 * @return: True or false 
	 */	
	public boolean isEqual(MyList<Integer> m1, MyList<Integer> m2){

		boolean result;

		// NOTE: Check if the two lists are the same length, if they are not then they cant be the same
		if (m1.length() != m2.length()){
			return false;
		} else if (m1.length() ==0 && m2.length() == 0){
			// NOTE: See if both lists are empty then return true
			return true;
		} else if (m1.length() ==1 && m2.length() ==1){
			// NOTE: See if both lists have 1 item and the item they contain are the same
			int item1 = m1.getElement(0);
			int item2 = m1.getElement(0);
			if (item1 == item2){
				return true;
			}
		}


		MyList<Integer> left1 = new MyDynamicList<>();
		MyList<Integer> right1 = new MyDynamicList<>();
		int rightIndex1 = 0;
		int leftIndex1 = 0;

		for (int i=0; i< m1.length(); i++){
			if (i < m1.length() / 2){
				left1.addElement(leftIndex1, m1.getElement(i));
				leftIndex1 ++;
			} else {
				right1.addElement(rightIndex1, m1.getElement(i));
				rightIndex1 ++;
			}
		}

		// NOTE: Same as before, split the list in two
		MyList<Integer> left2 = new MyDynamicList<>();
		MyList<Integer> right2 = new MyDynamicList<>();
		int rightIndex2 = 0;
		int leftIndex2 = 0;

		for (int i=0; i< m2.length(); i++){
			if (i < m2.length() / 2){
				left2.addElement(leftIndex2, m2.getElement(i));
				leftIndex2 ++;
			} else {
				right2.addElement(rightIndex2, m2.getElement(i));
				rightIndex2 ++;
			}
		}

		// NOTE: recursible call the is equal on the two left lists
		boolean leftResult = this.isEqual(left1, left2);

		// NOTE: recursive call on the two right lists
		boolean rightResult = this.isEqual(right1, right2);

		// NOTE: set the result to the AND of the two results and return.
		result = leftResult && rightResult;
		return result;
	}
	
		
	//-------------------------------------------------------------------
	// 4. fermat --> Computes the n-est term of the Fermat series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Fermat series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int fermat(int n){
		// NOTE: Not sure about divide and conquer algo here. Seems just like a math formula to me.
		if (n < 0){
			System.out.println("Error. n must be >= 0");
			return -1;
		} else {
			return (int) (Math.pow(2, Math.pow(2, n)) + 1);
		}
	}
		
}
