class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
      Arrays.sort(asteroids);
      int n = asteroids.length;
      long Mass = mass;

      for(int i=0; i<n; i++) {
        if(Mass < asteroids[i])
          return false;

         Mass += asteroids[i]; 
      }

      return true;
    }
}
