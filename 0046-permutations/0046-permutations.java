class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; //Track used element 
        backtrack(nums,new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        //Base case: if current size == nums.length -> a full permutation
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current)); //Copy current list
            return;
        }

        //Try all unused elements
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue; //Skip if already used

            current.add(nums[i]); //Choose

            used[i] = true;//Mark as used

            backtrack(nums, current, used, result); //Explore

            current.remove(current.size() - 1);//Undo choice (backtrack)
            used[i] = false; //Unmark
        }
    }
}