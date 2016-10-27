/*NAME  : YIJIA LIU
DATE  : 13 March 2015
CLASS : CSE373 A
Detail: Homework 5
This is a program comparing the difference of frequency of words in two articles
*/
public class Test {

	public static void main(String[] args) {
		FileInput.init();
		
		//Use the FileInput functions to read the two files.
		// Input the elements of those two files into two hash tables,
		// one file into a ChainingHash object and the other into a QPHash object.
      String[] sourceH = FileInput.readShakespeare();
      String[] sourceB = FileInput.readBacon();
      
      //Initialize the hash tables, one as chaining hash and the other as quadratic probing hash
      ChainingHash hamlet = new ChainingHash(sourceH.length);
      
      //find the smallest prime number such that lambda < 0.5 to be the size of hash table
      int size = sourceB.length*2;
      while(!isPrimeNumber(size))
         size++;
      QPHash bacon = new QPHash(size);
		
      for(int i = 0; i < sourceH.length; i++){
         hamlet.insert(sourceH[i]);
      }
      
      for(int i = 0; i < sourceB.length; i++){
         bacon.insert(sourceB[i]);
      }

		//Initialize necessary variables for calculating the square error
		// and most distant word.
      double TE = 0;
      double d = 0;
      String mdw = "";
		
		//Iterate through the first hash table and add sum the squared error
		// for these words.
      String key = hamlet.getNextKey();
		while (key != null) {
         double E = Math.pow((double)hamlet.findCount(key)/sourceH.length - (double)bacon.findCount(key)/sourceB.length,2);
         if(E > d){
            mdw = key;
            d = E;
         }   
         TE = TE + E;
         key = hamlet.getNextKey();
      }
		
      //Find  words in the second hash table that are not in the first and add their squared error
		// to the total
		key = bacon.getNextKey();
      while(key != null){
         if(!hamlet.containsKey(key)){
            double E = Math.pow((double)bacon.findCount(key)/sourceB.length,2);
            if(E > d){
               mdw = key;
               d = E;
            }
            TE = TE + E;            
         }
         key = bacon.getNextKey();
      }
      
            
		//Print the total calculated squared error for the two tables and also the word with the highest distance.
      System.out.println("Total Square Error: " + TE);
      System.out.println("Most different word: " + mdw);
	}
   
   //boolean method to determine if a number is a prime number
   private static boolean isPrimeNumber(int n){
      for(int i = 2; i < n; i++){
         if(n % i == 0)
            return false;
      }
      return true;
   }

}
