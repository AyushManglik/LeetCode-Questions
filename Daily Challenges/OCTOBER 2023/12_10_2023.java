 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int leftSearch = binarySearch(0, peak,target,true, mountainArr);
        if(leftSearch != -1) return leftSearch;
        return binarySearch(peak+1, mountainArr.length()-1, target, false , mountainArr);
    }

    public int findPeak(MountainArray mountainArr){
        int left = 0, right = mountainArr.length() - 1;
        while(left < right){
            int mid = left + (right - left) / 2; 
            if(mid < right && mountainArr.get(mid) < mountainArr.get(mid+1)){
                left = mid + 1;
            }else right = mid;
        }
        return left;
    }

    public int binarySearch(int left, int right, int target, Boolean isAscending, MountainArray mountainArr){
        while(left <= right){
            int mid = left + (right - left) / 2; 
            if(mountainArr.get(mid) == target) return mid;
            if(isAscending){
                if(mountainArr.get(mid) < target) left = mid + 1;
                else right = mid -1;
            }else {
                if(mountainArr.get(mid) < target) right = mid -1;
                else left = mid + 1;
            }     
        }
        return -1;
    }
}
