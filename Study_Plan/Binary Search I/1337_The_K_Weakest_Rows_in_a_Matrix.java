import java.util.Collections;
class data{
    int row,solider;
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        data array[]=new data[mat.length];
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0)
                    break;
                sum+=mat[i][j];
            }
            array[i]=new data();
            array[i].row=i;
            array[i].solider=sum;
           
            
            
        }
         Arrays.sort(array,(a,b)->(a.solider-b.solider));
        int result[]=new int[k];
        
        for(int i=0;i<k;i++)
            result[i]=array[i].row;
        return result;
            
    }
}
