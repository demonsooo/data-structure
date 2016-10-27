/*NAME  : YIJIA LIU
DATE  : 13 March 2015
CLASS : CSE373 A
Detail: Homework 5
This is a class defining a Hash table utilizing chaining technique
*/
public class ChainingHash {
      Record[] table;
      int index;
      Record current;
      
     //Implement a default constructor for ChainingHash 
		public ChainingHash(){
         table = new Record[5000];
         index = -1;
		}
      
		//Implement a constructor that instantializes the hash array to startSize.
		public ChainingHash(int startSize){			
         table = new Record[startSize];
         index = -1;
		}

		// Returns the next key in the hash table. Returns null if it is at its end.
		public String getNextKey(){
         if (current == null || current.next == null) {
            if(index == table.length - 1){
               return null;
            } else {
               index++;
               while(index < table.length - 1 && table[index] == null)
                  index++;
               current = table[index];
               if(current == null)
                  return null;
               return current.key;
            }
         }else{
            current = current.next;
            return current.key;
         }
		}
		
      /**
       * Adds the key to the hash table.
		 * If the key is already in the hash table, it increments its count.
		 */
		public void insert(String keyToAdd){ 
         int code = hash(keyToAdd);
         Record r = table[code];
         if(r == null){
            table[code] = new Record(keyToAdd);
         } else {
            if(containsKey(keyToAdd)){              
               while(r != null) {
                  if(r.key.equals(keyToAdd)){
                     r.count ++;
                     break;
                  } else {
                     r = r.next;
                  }
               }
            } else {
               table[code] = new Record(keyToAdd, r);
            }
         }
		}
      
      //returns true if a given key is in the hash table, returns false if not
      public boolean containsKey(String key){
         int code = hash(key);
         if(table[code] == null)
            return false;
         Record r = table[code];
         while(r != null) {
            if(r.key.equals(key)){
               return true;
            } else {
               r = r.next;
            }
         }
         return false;
      }
            
		//Returns the number of times a key has been added to the hash table.
		public int findCount(String keyToFind){
         int code = hash(keyToFind);
         Record r = table[code];
         while(r != null) {
            if(r.key.equals(keyToFind)){
               return r.count;
            } else {
               r = r.next;
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
