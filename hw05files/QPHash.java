/*NAME  : YIJIA LIU
DATE  : 13 March 2015
CLASS : CSE373 A
Detail: Homework 5
This is a class defining a Hash table utilizing quadratic probing technique
*/
public class QPHash {
      Record[] table;
      int index;
      int times;
      
		public QPHash(){
			//Implement a default constructor for QPHash
         table = new Record[9973];
         index = -1;      
		}
		
		public QPHash(int startSize){
			//Implement a constructor that instantializes the hash array to startSize.
         table = new Record[startSize];
         index = -1;
		}


		// Returns the next key in the hash table. Returns null if it is at its end.
		public String getNextKey(){
         if(index < table.length - 1){
            index++;
            while(index < table.length - 1 && table[index] == null)
               index++;
            if(table[index] != null)
               return table[index].key;
         } 
         return null;
      }
         

		/* Adds the key to the hash table.
		 * If there is a collision, a new location will be found using quadratic probing.
		 * If the key is already in the hash table, then increment its count
		 */
		public void insert(String keyToAdd){
         int code = hash(keyToAdd);
         int i = 0;
         while(true){
            int prob = Math.abs(code + i*i)%table.length;           
            if(table[prob] == null){
               table[prob] = new Record(keyToAdd);
               return;
            } else if(table[prob].key.equals(keyToAdd)) {
               table[prob].count++;
               return;
            } else {
               i++;
            }
         }                               
		}
      
		//Returns the number of times a key has been added to the hash table.
		public int findCount(String keyToFind){
         int code = hash(keyToFind);
         for(int i = 0; i <= table.length; i++){
            int prob = Math.abs(code + i*i)%table.length;
            if(table[prob] != null && table[prob].key.equals(keyToFind)){
               return table[prob].count;
            }
         }
         return 0;
		}
      
      //returns a hashcode of a given string
		private int hash(String keyToHash){
         int n = 0;
         for (int i = 1; i < keyToHash.length(); i++)
            n = n * 10 + (int)keyToHash.charAt(i)%10;
         return Math.abs(n%table.length);  
		}
}
