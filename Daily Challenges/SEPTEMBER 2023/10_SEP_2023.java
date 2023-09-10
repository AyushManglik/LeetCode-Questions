class Solution {
    public int countOrders(int n) {
        //we know the (n-1) pair answer
        //to find nth we can insert first element to 2*i-1 poistion
        //we can insert second element to 2*n poistions
        long ans=1,mod=(long)1e9+7;
        for(int i=1;i<=n;i++){
            ans=ans*(2*i-1)*i % mod;
        }
        return (int)ans;
    }
}

// PD
// _P_D_    =>  insert first element (3 possibility)
// _-P-D-   => if put first element at _ then second possibility -
// P_-D-
// PD_-

//total first possibity 3 (2*n-1)
//total second possibility 6 (2*n)
//result    =>   (2n-1)2n

//delivery is always after pickup
//real result   =>  (2n-1)n
