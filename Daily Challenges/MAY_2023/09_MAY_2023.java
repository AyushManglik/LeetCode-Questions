//54. Spiral Matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int rowStart=0;
        int rowEnd=matrix.length-1;
        int colStart=0;
        int colEnd=matrix[0].length-1;

        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i=colStart;i<=colEnd;i++){
                list.add(matrix[rowStart][i]);
            }
            rowStart++;

            for(int j=rowStart;j<=rowEnd;j++){
                list.add(matrix[j][colEnd]);
            }
            if(rowStart<=rowEnd){
            colEnd--;

            for(int k=colEnd;k>=colStart;k--){
                list.add(matrix[rowEnd][k]);
            }}
            
            rowEnd--;
        if(colStart<=colEnd){
            for(int l=rowEnd;l>=rowStart;l--){
            list.add(matrix[l][colStart]);
            }
            colStart++;
        }}
        return list;
    }
}
