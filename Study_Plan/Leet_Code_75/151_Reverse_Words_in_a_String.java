class Solution {
    public String reverseWords(String s) {

            char[] original = s.toCharArray(); 
            char[] finalArray = new char[original.length]; 
            int i=original.length-1,j,k,r=0;

            //this will remove any trailing spaces
            while(original[i]==' ')
                i--;

            while(i>=0){
              //j points to the last character of the word
              j=i; 

              //find the space before the first character of the word
              while( i>=0 && original[i] != ' ')
                i--;
              //adding additional space if it's not the first character'  
              if(r>0){
                  finalArray[r++]=' ';
              }

              for(k=i+1;k<=j;k++){
                  finalArray[r++]=original[k];
              }  
              while(i>=0 && original[i] == ' ')
                i--;
            }

            return new String(finalArray,0,r);


    




        // s = s.trim();

        // String[] strArray = s.split("\\s+"); 

        // for(int i =0;i<strArray.length/2;i++){
        //     String temp = strArray[i]; 
        //     strArray[i]=strArray[strArray.length-1-i]; 
        //     strArray[strArray.length-1-i]=temp;
        // }

        // return String.join(" ",strArray);
        
    }
}
