public class HW2Prob2 {
	public static void main(String args[]) {
		int n ;

		/*try {
			n = Integer.parseInt(args[0]);
		}
		catch(Exception e) {
			System.out.println("Please provide an integer value for n as a command line argument.");
			return;
		}
      */

		long startTime = System.currentTimeMillis();
		long sum = 0;
		// INSERT YOUR CODE HERE
      n = 2000;
      for (int i=0; i<n; i++){
         for (int j=1; j<i*i; j++){
            if (j % i == 0){
               for (int k=0; k<j; k++)
                  sum++;
            }
         }
      }

		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " milliseconds, and the loop body was executed " + sum + " times.");
	}
}
