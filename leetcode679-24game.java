/*
You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) 
to get the value of 24.
*/

class Solution {
    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> arrayList = new ArrayList();
        for (int i : nums) arrayList.add((double) i);

        return game24helper(arrayList, 0);
    }

    boolean game24helper(ArrayList<Double> nums, double cur) {
        if (nums.size() == 1 && (cur >= 23.99999 && cur <= 24.00001)) return true;
        if (nums.size() == 1 && cur != 24) return false;

        ArrayList<Boolean> results = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    ArrayList<Double> numsCopy = new ArrayList();
                    for (double k : nums) numsCopy.add(k);
                    double a = numsCopy.get(i);
                    double b = numsCopy.get(j);
                    numsCopy.remove(i);
                    if (i < j) numsCopy.remove(j - 1);
                    else {
                        numsCopy.remove(j);
                    }

                    ArrayList<Double> list1 = new ArrayList();
                    for (double k : numsCopy) list1.add(k);
                    list1.add(a*b);
                    if (game24helper(list1, a * b)) return true;

                    ArrayList<Double> list2 = new ArrayList();
                    for (double k : numsCopy) list2.add(k);
                    list2.add(a+b);
                    if (game24helper(list2, a + b)) return true;

                    ArrayList<Double> list3 = new ArrayList();
                    for (double k : numsCopy) list3.add(k);
                    if (b != 0) {
                        list3.add(a/b);
                        if (game24helper(list3, a/b)) return true;
                    }

                    ArrayList<Double> list4 = new ArrayList();
                    for (double k : numsCopy) list4.add(k);
                    if (a != 0) {
                        list4.add(b/a);
                        if (game24helper(list4, b/a)) return true;
                    }

                    ArrayList<Double> list5 = new ArrayList();
                    for (double k : numsCopy) list5.add(k);
                    list5.add(a-b);
                    if (game24helper(list5, a - b)) return true;

                    ArrayList<Double> list6 = new ArrayList();
                    for (double k : numsCopy) list6.add(k);
                    list6.add(b-a);
                    if (game24helper(list6, b - a)) return true;
                }
            }
        }
        return false;
    }
}
