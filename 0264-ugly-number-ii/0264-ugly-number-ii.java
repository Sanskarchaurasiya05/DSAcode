class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n+1];
        int i2=1,i3=1,i5=1;
        res[1]=1;
        for(int i=2 ; i<=n ; i++){
            int i2ugly = res[i2]*2;
            int i3ugly = res[i3]*3;
            int i5ugly = res[i5]*5;

            int minugly = Math.min(i2ugly , Math.min(i3ugly , i5ugly));

            res[i]=minugly;
            
            if(minugly==i2ugly)
            i2++;

            if(minugly==i3ugly)
            i3++;

            if(minugly==i5ugly)
            i5++;

        }

        return res[n];
    }
}