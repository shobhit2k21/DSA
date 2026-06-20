class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
   int m = restrictions.length;
        
        // 1. Create a complete list of restricted points including building 1 and building n
        int[][] allRestrictions = new int[m + 2][2];
        allRestrictions[0] = new int[]{1, 0}; // Building 1 always has height 0
        allRestrictions[1] = new int[]{n, n - 1}; // Building n can at most be n - 1
        
        for (int i = 0; i < m; i++) {
            allRestrictions[i + 2] = restrictions[i];
        }
        
        // Sort based on building ID
        Arrays.sort(allRestrictions, (a, b) -> Integer.compare(a[0], b[0]));
        
        int totalLen = allRestrictions.length;
        
        // 2. Forward pass: Left to Right propagation
        for (int i = 1; i < totalLen; i++) {
            int maxPossibleFromLeft = allRestrictions[i - 1][1] + (allRestrictions[i][0] - allRestrictions[i - 1][0]);
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], maxPossibleFromLeft);
        }
        
        // 3. Backward pass: Right to Left propagation
        for (int i = totalLen - 2; i >= 0; i--) {
            int maxPossibleFromRight = allRestrictions[i + 1][1] + (allRestrictions[i + 1][0] - allRestrictions[i][0]);
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], maxPossibleFromRight);
        }
        
        // 4. Find the peak between every adjacent pair
        int maxBuildingHeight = 0;
        for (int i = 0; i < totalLen - 1; i++) {
            int id1 = allRestrictions[i][0];
            int h1 = allRestrictions[i][1];
            int id2 = allRestrictions[i + 1][0];
            int h2 = allRestrictions[i + 1][1];
            
            // Peak formula: (dist + h1 + h2) / 2
            int peak = (id2 - id1 + h1 + h2) / 2;
            maxBuildingHeight = Math.max(maxBuildingHeight, peak);
        }
        
        return maxBuildingHeight;
    }
}
