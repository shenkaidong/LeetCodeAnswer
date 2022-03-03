//Design a data structure that accepts a stream of integers and checks if it has
// a pair of integers that sum up to a particular value. 
//
// Implement the TwoSum class: 
//
// 
// TwoSum() Initializes the TwoSum object, with an empty array initially. 
// void add(int number) Adds number to the data structure. 
// boolean find(int value) Returns true if there exists any pair of numbers whos
//e sum is equal to value, otherwise, it returns false. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["TwoSum", "add", "add", "add", "find", "find"]
//[[], [1], [3], [5], [4], [7]]
//Output
//[null, null, null, null, true, false]
//
//Explanation
//TwoSum twoSum = new TwoSum();
//twoSum.add(1);   // [] --> [1]
//twoSum.add(3);   // [1] --> [1,3]
//twoSum.add(5);   // [1,3] --> [1,3,5]
//twoSum.find(4);  // 1 + 3 = 4, return true
//twoSum.find(7);  // No two integers sum up to 7, return false
// 
//
// 
// Constraints: 
//
// 
// -105 <= number <= 105 
// -231 <= value <= 231 - 1 
// At most 104 calls will be made to add and find. 
// 
// Related Topics Array Hash Table Two Pointers Design Data Stream 
// 👍 510 👎 359


//leetcode submit region begin(Prohibit modification and deletion)
class TwoSum {

    private Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (int num : map.keySet()) {
            int complement = value - num;
            if (complement != num && map.containsKey(complement)) return true;
            if (complement == num && map.get(num) >= 2) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
//leetcode submit region end(Prohibit modification and deletion)
