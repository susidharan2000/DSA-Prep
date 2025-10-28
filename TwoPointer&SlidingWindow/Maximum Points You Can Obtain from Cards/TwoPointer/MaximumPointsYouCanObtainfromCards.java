

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftPoint = 0;
        int rightPoint = 0;
        int maxPoint = 0;
        int l = -1;
        int r = n-1;
        for(r = n-1;r>= n-k;r--){
            rightPoint+=cardPoints[r];
        }
        maxPoint = rightPoint;
        for(int i = 0;i<k;i++){
            leftPoint+=cardPoints[i];
            rightPoint-=cardPoints[n-k+i];
            maxPoint = Math.max(leftPoint+rightPoint,maxPoint);
        }
        return maxPoint;
    }
}