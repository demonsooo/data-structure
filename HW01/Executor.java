/*NAME  : YIJIA LIU
DATE  : 13 Jan 2015
CLASS : CSE373 A
Detail: Homework 1
This is a program putting questions randomly to oracles and print the combinations of answer and question
from each oracle.
*/

public class Executor {

	public static void main(String[] args) {
		Utility.init(); // initializes file readers
		String[] questions = Utility.readQuestions(); //reads question.txt file into questions array
		String[] answers = Utility.readAnswers(); // reads answers.txt file into answers array
		
		int numOracles = answers.length; //finds the number of oracles
		
		//TODO Assign questions to oracles using Utility.random and print the question paired with the oracle response
		// 1. Initialize one ArrayQueue per oracle (arrays will work best).
		ArrayQueue[] oracleQ = new ArrayQueue[numOracles];
		for(int i = 0; i < numOracles; i++ ) 
			oracleQ[i] = new ArrayQueue();
		// 2. Put the questions into the queues, assigning each one to the queue of the oracle whose number is returned 
		//by the random number generator.
		for(int i = 0; i < questions.length; i++) {
			oracleQ[Utility.random(numOracles)].enqueue(questions[i]);
		}
		// 3. Loop through the oracles, having each one remove a question from its queue (if empty do nothing) and 
		//answer it with its unique answer (oracle[k] uses answers[k]). Do this repeatedly till all queues become empty.
      
      int n = 0;//initialize the number of answered question
      int i = -1;//initialize the sequence of oracles
		while(n < questions.length){
         i++;
			int oracle = i % numOracles;
			//print the oracle¡¯s response and the original question
			if(!oracleQ[oracle].isEmpty()){
				System.out.println(oracleQ[oracle].dequeue()+":"+" "+answers[oracle]);
            n++;
         }
		}
	}
}

