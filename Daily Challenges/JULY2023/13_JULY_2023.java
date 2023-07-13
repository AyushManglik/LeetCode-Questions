class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
            // if no courses then it is true
        }

        int[] course = new int[numCourses];
        // new array length of num of courses
        for(int i = 0; i<prerequisites.length; i++){
            course[prerequisites[i][1]]++;
        }
        // so iterate through and initialise the course array
        // course array tracks how many times this course is a prerequisite

        boolean[] visited = new boolean[prerequisites.length];
        // array to track if each node has been visited
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i<prerequisites.length; i++){
                if(!visited[i]){
                    // if node has not been visited
                    if(course[prerequisites[i][0]]== 0){
                        visited[i] = true;
                        course[prerequisites[i][1]]--;
                        flag = true;
                        // if the element is not a prerequisite
                        // mark it as visited node
                        // decrement value of the course it is dependent on
                        // flag is set to true to continue iteration
                    }
                }
            }
        }
        for(int i = 0; i<numCourses; i++){
            if (course[i] != 0){
                return false;
            }
        }
        return true;
    
    }
}
