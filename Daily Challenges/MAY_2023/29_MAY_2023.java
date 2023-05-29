/*
class ParkingSystem {
    private int arr[];
    public ParkingSystem(int big, int medium, int small) {
        arr = new int[]{big,medium,small};
    }
    
    public boolean addCar(int carType) {
        if(arr[carType-1]>0)
        {   
            arr[carType-1]--;
            return true;
        }
        return false;
    }
}
*/
class ParkingSystem {

     int[] m;

   public ParkingSystem(int big, int medium, int small) {
       m = new int[]{big,medium,small};
   }
   
 
   
   public boolean addCar(int carType) {
	   return m[carType - 1] --> 0;
	   
   }
}
