public class h6{

   public static void main(String[] args) {
   	int[][] matrix = {{0,5,3,-1,-1,-1,-1},{-1,0,2,-1,-1,-1,1},
   			{-1,-1,0,7,7,-1,-1},{2,-1,-1,0,-1,6,-1}, {-1,-1,-1,2,0,1,-1},
   			{-1,-1,-1,-1,-1,0,-1},{-1,-1,-1,-1,1,-1,0}};  
   	dijkstra(matrix);   	
	}
    public static void dijkstra(int[][] m) {
		node[] nodes = new node[7];
		int know = 0;
		for (int i = 0; i < 7; i++){
			nodes[i] = new node();
		}
		nodes[0].cost = 0;
      nodes[0].path = "";
		while(know < 7){
			int minC = 9999;
			int mark = 0;
			for (int i = 0; i < 7; i++){
				if(nodes[i].known == false){
					if(nodes[i].cost < minC){
						minC = nodes[i].cost;
						mark = i;
               }
				}
			}
			nodes[mark].known = true;
			know++;
			for (int j = 0; j < 7; j++){
				if(nodes[j].known == false){
					if (m[mark][j] > 0){
						int C = nodes[mark].cost + m[mark][j];
						if(C < nodes[j].cost){
							nodes[j].cost = C;
							nodes[j].path = "" + mark;
						}
					}
				}
			}
			for (int k = 0; k < 7; k++)
				System.out.print(nodes[k].cost + " ");
         System.out.println();		
		}
      for(int i = 0; i < 7; i++)
         System.out.println("Node: " + i + " Cost: " + nodes[i].cost + " Path: " + nodes[i].path);	
	}

}