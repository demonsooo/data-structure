public class Record{
    String key;
    int count;
    Record next;
    
    Record(String word) {
      key = word;
      count = 1;
    }
    
    Record(String word, Record r){
      key = word;
      count = 1;
      next = r;
   }
      

}
