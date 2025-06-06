class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {return result; //edge case
        }

        //Initialize the map
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        //Start backtracking
        backtrack(0, digits, new StringBuilder(), result, phoneMap);

        return result;
    }

    private void backtrack(int index, String digits, StringBuilder current, List<String> result, Map<Character, String> phoneMap) {
        //Base case
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }

        //Recursive case
        char digit = digits.charAt(index);

        String letters = phoneMap.get(digit);

        for(char letter : letters.toCharArray()) {
            current.append(letter); 
            //Choose
            backtrack(index + 1, digits, current, result, phoneMap); //Explore

            current.deleteCharAt(current.length() - 1); // Un-choose(backtrack)
        }
    }
}