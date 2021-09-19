
/**
* The main class of our project.<br>. 
*/
public class MyMain {
	
	/**
	 * This function is used to test the divide and conquer algorithms.
	 */
	public static void test(){
		//1. We create the object to test the exercises
		DivideAndConquerAlgorithms ex = new DivideAndConquerAlgorithms();
		
		//2. We create extra variables for the tests
		
		// m1 = []
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		// m2 = [9,3,2]
		MyList<Integer> m2 = new MyDynamicList<Integer>();
		m2.addElement(0, 9);
		m2.addElement(1, 3);
		m2.addElement(2, 2);
		
		// m3 = [4,8,1,3,6,5,2,6]		
		MyList<Integer> m3 = new MyDynamicList<Integer>();
		m3.addElement(0, 4);
		m3.addElement(1, 8);
		m3.addElement(2, 1);	
		m3.addElement(3, 3);			
		m3.addElement(4, 6);
		m3.addElement(5, 5);
		m3.addElement(6, 2);	
		m3.addElement(7, 6);	
		
		//3. We create extra variables for the results		
		int resI = 0;
		boolean resB = false; 
		MyList<Integer> resM = null;
		
		//---------------------
		// TESTS
		//---------------------		

		//----------------------------
		//1. We test getEven
		//----------------------------
		System.out.println("\n----------- Test: getEven -------------\n");
		
		resM = ex.getEven(m1);
		iterativeDisplayElements(resM);
		
		resM = ex.getEven(m2);
		iterativeDisplayElements(resM);		
		
		resM = ex.getEven(m3);
		iterativeDisplayElements(resM);
		
		//----------------------------
		//2. We test getProduct
		//----------------------------
		System.out.println("\n----------- Test: getProduct -------------\n");
	
		resI = ex.getProduct(m1);
		System.out.println(resI);
		
		resI = ex.getProduct(m2);
		System.out.println(resI);		
		
		resI = ex.getProduct(m3);
		System.out.println(resI);		
		
		//----------------------------
		//3. We test isEqual
		//----------------------------	
		System.out.println("\n----------- Test: isEqual -------------\n");
		
		resB = ex.getNumAppearances(m1, m1);
		System.out.println(resB);
		
		resB = ex.getNumAppearances(m3, m2);
		System.out.println(resB);		
		
		resB = ex.getNumAppearances(m3, m3);
		System.out.println(resB); 		
		
				
		//----------------------------
		//4. We test lucas
		//----------------------------
		System.out.println("\n----------- Test: fermat -------------\n");

		resI = ex.fermat(0);
		System.out.println(resI);
		
		resI = ex.fermat(3);
		System.out.println(resI);

		resI = ex.fermat(9);
		System.out.println(resI);
		
		
	}
	
	/**
	 * Main Method.
	 * @param args: We will run the program parameter free, so do not worry about it.
	 */
	public static void main(String[] args) {
		test();	
	}

}
