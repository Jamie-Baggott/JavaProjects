//Name: Jamie Baggott
//Student Number: R00149982 


import java.util.HashMap;

/**
* Classical Change making problem with an unlimited amount of coins of each type. <br> 
* Version 2: Selection function with more elaborated policy: First biggest-coin.<br> 
* Depending on the type of coins, it can lead to an optimal solution.<br>
* The class encapsulates all the functions of the Greedy schema<br>
*/

public class ChangeMaking {

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public ChangeMaking(){}

	
	// -------------------------------------------------------------------
	// 1. selectionFunctionFirstCandidate--> It selects the first candidate 
	// -------------------------------------------------------------------
	/**
	 * Given a current solution that is not a final solution, this function
	 * selects the new candidate to be added to it.<br>
	 * The policy followed is very simple: Just pick the first unused item.
	 * 
	 * @param candidates:
	 *            The MyList stating whether a candidate has been selected so
	 *            far or not.
	 * @return: The index of first candidate to be selected.
	 */
	public int selectionFunctionFirstCandidate(MyList<Integer> candidates) {//no limit to the amount of times you can choose a coin; all candidates can be considered at all times.
		// NOTE: Just checking to make sure there are some coins available. If there is then return the first one.
		// NOTE: Because in the solve method we are only passing valid coins (ones that are not too big), we do not have to worry about selecting an invalid coin
		if (candidates.length() > 0){
			return candidates.getElement(0);
		} else {
			return 0;
		}
	}

		
	//-------------------------------------------------------------------
	// 1. selectionFunction --> It selects the next candidate to be considered.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br> 
	 * The policy followed is more elaborated: Pick the best (largest) coin according to the objective function of minimizing the number
	 * of coins that make the change of the amount. 
	 * @param candidates: List of candidates
	 * @return: The index of candidate to be selected.
	 */	
	public int selectionFunctionBestCandidate(MyList<Integer> coinValues, MyList<Integer> candidates ){//no limit to the amount of times you can choose a coin; all candidates can be considered at all times.
		// NOTE: I dont think coinValues was meant to be included as paramter because I didn't need it and it wasn't included in the Javadoc above.

		// NOTE: Make sure that there are some candidates available
		if (candidates.length() > 0){
			// NOTE: Set the max to -1. This is used for comparison later. We use -1 because it is smaller than all other possible coins.
			int max = -1;
			// NOTE:  Loop through the list of possible candidates and return the largest one. Because in the solve method we are only passing valid coins (ones that are not too big), we do not have to worry about selecting an invalid coin
			for (int i=0; i<candidates.length(); i++){
				int item = candidates.getElement(i);
				if (item > max){
					max = item;
				}
			}
			return max;
		} else {
			return 0;
		}
	}
	
	//-------------------------------------------------------------------
	// 2. feasibilityTest --> It selects if a candidate can be added to the solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution and a selected candidate, this function 
	 * states whether the candidate must be added to the solution or discarded.<br> 
	 * @param candidateValue: The value of the candidate coin selected. 
	 * @param amount: The amount of change we want to generate.
	 * @param changeGenerated: The quantity of change we have generated so far. 
		 * @return: Whether the candidate fits or not into the solution.
	 */	

	public boolean feasibilityTest(int candidateValue, int amount, int changeGenerated){
		// int difference = amount - changeGenerated;
		// NOTE: Didn't need the change generated parameter because we are passing the updated amount required from the solve. The above line shows how we would do it if we were not updating amount in the solve method.
		int difference = amount;
		return  candidateValue <= difference;
	}
	
	// -------------------------------------------------------------------
	// 5. solutionTest --> It selects if the current solution is the final
	// solution
	// -------------------------------------------------------------------
	/**
	 * Given a current solution, this function states whether it is a final
	 * solution or it can still be improved.<br>
	 * To determine it, it checks whether there is (at least) one item not
	 * picked before that fits into the knapsack.
	 * 
	 * @param nbCandidates:
	 *            number of candidates that have not been yet selected by the
	 *            selection function
	 * @return: Whether the current solution is the final solution.
	 */
	public boolean solutionTest(MyList<Integer> candidates) {
		// NOTE: Just check to see if there are any possible candidates left. If they are not then return ture because we are done.
		return candidates.length() == 0;
	}


	//-------------------------------------------------------------------
	// 4. objectiveFunction --> This function computes the value of the final solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given the final solution to the problem, this function 
	 * computes its objective function value according to:<br>
	 * How many coins are used in the solution.<br>
	 * @param sol: The MyList containing the solution to the problem. 
	 * @return: The objective function value of such solution.
	 */	
	public int  objectiveFunction(MyList<Integer> sol){
		// NOTE: Not sure if we were supposed to count all the coins or just the unique ones so I did unique.

		// NOTE: Set the count to 0 (we havent started counting yet)
		int count = 0;

		// NOTE: Set previous to -1, we will use this later and we need to set it to an impossible coin value.
		int previous = -1;

		// NOTE: Loop through each item, check if it is equal to the previos coin. If not then it is a new coin so increment the count. Update the previous item to the current item.
		for(int i=0; i < sol.length(); i++){
			int item = sol.getElement(i);
			if (item != previous){
				count ++;
			}
			previous = item;
		}
		return count;
	}
	
	//-------------------------------------------------------------------
	// 5. solve --> This function solves the problem using a greedy algorithm.  
	//-------------------------------------------------------------------	
	/**
	 * Given an instance of the GP1 problem, this function solves it using 
	 * a greedy algorithm.<br> 
	 * @param typeSelectFunc:
	 *            Type of selection function to choose.
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: A MyList containing the amount of coins of each type being selected.
	 */	
	public MyList<Integer> solve(int typeSelectFunc, MyList<Integer> coinValues, int amount){//if the feasabliityTest retuns false (using this coin takes us to an invalid state), then item should no longer be considered; set the candidate to 1 in itemsCOnsidered list.
		// NOTE: create a list for our solution.
		MyList<Integer> sol = new MyDynamicList<>();

		// NOTE: Keep track of the amount of change we have generate so far. This will be used to work out the next piece of change we need.
		int changeGenerated = 0;

		// NOTE: Check if what function we are supposed to be using. 1 = dummy, 2 = smart.
		if (typeSelectFunc == 1){

			// NOTE: Loop while we still have change to generate.
			while (amount > 0) {
				// NOTE: Create a list that wil be used to hold our valid coins.
				MyList<Integer> validCoinValues = new MyDynamicList<>();

				// NOTE: Loop through all the coins that are available.
				for (int i = 0; i < coinValues.length(); i++) {
					int value = coinValues.getElement(i);

					// NOTE: Check if the coin can be used and isn't too big.
					if (this.feasibilityTest(value, amount, changeGenerated)) {

						// NOTE: Add the coin to the end of our list keeping track of the valid coins
						validCoinValues.addElement(validCoinValues.length(), value);
					}
				}

				// NOTE: If we have found a valid solution then break out of the loop
				if (this.solutionTest(validCoinValues)){
					break;
				}

				// NOTE: Select the coin we will be using.
				int change = this.selectionFunctionFirstCandidate(validCoinValues);

				// NOTE: Take the coin from the total amount we have remaining.
				amount -= change;

				// NOTE: Add the coin to our list keeping track of our soloution.
				sol.addElement(sol.length(), change);
			}

		} else {
			// NOTE: Loop while we still have change to generate.
			while (amount > 0) {
				// NOTE: Create a list that wil be used to hold our valid coins.
				MyList<Integer> validCoinValues = new MyDynamicList<>();

				// NOTE: Loop through all the coins that are available.
				for (int i = 0; i < coinValues.length(); i++) {
					int value = coinValues.getElement(i);

					// NOTE: Check if the coin can be used and isn't too big.
					if (this.feasibilityTest(value, amount, changeGenerated)) {

						// NOTE: Add the coin to the end of our list keeping track of the valid coins
						validCoinValues.addElement(validCoinValues.length(), value);
					}
				}

				// NOTE: If we have found a valid solution then break out of the loop
				if (this.solutionTest(validCoinValues)){
					break;
				}

				// NOTE: Select the coin we will be using.
				int change = this.selectionFunctionBestCandidate(validCoinValues, validCoinValues);

				// NOTE: Take the coin from the total amount we have remaining.
				amount -= change;

				// NOTE: Add the coin to our list keeping track of our soloution.
				sol.addElement(sol.length(), change);
			}

		}

		// NOTE: Loop through our solution and print out each coin
		for (int i=0; i<sol.length(); i++){
			System.out.print(sol.getElement(i));
			System.out.print("c, ");
		}
		System.out.println();
		// NOTE: Get how many uniuqe coins we have and print it.
		int numCoins = this.objectiveFunction(sol);
		System.out.print("Number of unique coins used: ");
		System.out.println(numCoins);

		// NOTE: Return our list of change.
		return sol;
	}

}
