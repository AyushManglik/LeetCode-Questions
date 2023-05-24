class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
         Pair[] arr = new Pair[nums1.length]; 
         for(int i =0; i<nums1.length; i++){
              arr[i] = new Pair(nums1[i], nums2[i]); 
         }
          Arrays.sort(arr,new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                 return p2.n2-p1.n2; 
            }
        } ); 
        long ans = -1; 
        PriorityQueue<Integer>  pq = new PriorityQueue<>(); 
         long  s =0; 
        for(int i =0; i<k; i++){
             pq.add(arr[i].n1); 
             s  +=arr[i].n1; 
        }
        ans= Math.max(ans, (s* arr[k-1].n2)); 

         for(int i = k; i<arr.length; i++){
              if(arr[i].n1>pq.peek()){
                   int r = pq.remove(); 
                   s = s-r;
                   pq.add(arr[i].n1); 
                   s+=arr[i].n1; 
              }
                ans= Math.max(ans, (s* arr[i].n2)); 

              
         }
          return ans; 
    

        
    
    }
}
 class Pair{
      int n1; 
      int n2; 
      Pair(int n1,int n2){
           this.n1 = n1; 
           this.n2 = n2; 

      }
 }
