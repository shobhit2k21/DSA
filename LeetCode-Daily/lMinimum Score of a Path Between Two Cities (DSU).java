class Solution {
    int[] parent;
    int[] rank;
    int[] minScore;

     private int find(int node) {
      if (parent[node] == node)
          return node;

      return parent[node] = find(parent[node]);
  }

     private void UnionByRank(int a, int b, int score) {
        int parent_a= find(a);
        int parent_b= find(b);
        
        if(parent_a == parent_b){
             minScore[parent_a] = Math.min(score, minScore[parent_b]);

             parent[parent_b]= parent_a;  
             return;
        }
        
          if(rank[parent_a] > rank[parent_b]) {
               minScore[parent_a] = Math.min(score,
                Math.min(minScore[parent_a], minScore[parent_b]));
               parent[parent_b]= parent_a; 

          }
          
              else if(rank[parent_a] < rank[parent_b]) {
                    minScore[parent_b] = Math.min(score,
                Math.min(minScore[parent_a], minScore[parent_b]));
                   parent[parent_a] = parent_b; 
              }
                   
                   else {
                      minScore[parent_a] = Math.min(score,
                Math.min(minScore[parent_a], minScore[parent_b]));
                     parent[parent_b]= parent_a; 
                     rank[parent_a]+=1;
                   }        
    }

    public int minScore(int n, int[][] roads) {
        parent = new int[n+1];
        rank = new int[n+1];
        minScore = new int[n+1];

        for(int i=1; i<=n; i++) {
            parent[i] = i;
            rank[i] = 1;
            minScore[i] = Integer.MAX_VALUE;
        }

        for(int[] arr : roads) {
            UnionByRank(arr[0], arr[1], arr[2]);
        }
        
       return minScore[find(n)]; 
    }
}

 
