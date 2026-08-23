class Solution {
    public boolean sumGame(String num) {
      int n = num.length();
      int leftquesMark = 0, rightquesMark = 0;
      int leftSum = 0, rightSum = 0;
      int i = 0;
 
      for(i=0; i<n/2; i++) {
        char ch = num.charAt(i);  
        if(ch == '?')
         leftquesMark++;
        else
         leftSum += (ch - '0'); 
      }  


       for(i=i; i<n; i++) {
        char ch = num.charAt(i);
        if(ch == '?')
         rightquesMark++;
        else
         rightSum += (ch - '0'); 
      }  

      if((leftquesMark + rightquesMark) % 2 == 1) {
           return true;  
      }

      return ((2*leftSum + 9*leftquesMark) != (2*rightSum + 9*rightquesMark));

    }
}
