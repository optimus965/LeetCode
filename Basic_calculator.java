class Solution {
    public int calculate(String s) {
       return this.sol("1+" + s,0)[0] - 1;
    }
    public int[] sol(String s,int index) {
        int sum = 0;
        char type = '+';
        int count =0;
        for(int i =index;i < s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                if(i + 1 < s.length()) {
                    if(!Character.isDigit(s.charAt(i + 1))) {
                         if(type == '+') {
                         sum = sum + (count*10 + (s.charAt(i) - '0'));
                        }
                        else {
                          sum = sum - (count*10 + (s.charAt(i) - '0'));
                        }
                        count =0;
                    }
                    else {
                        count = count*10 + (s.charAt(i) - '0');
                    }
                }
                else {
                     if(type == '+') {
                         sum = sum + (count*10 + (s.charAt(i) - '0'));
                        }
                        else {
                          sum = sum - (count*10 + (s.charAt(i) - '0'));
                        }
                }
               
            }
            else if(s.charAt(i) == '-') {
                type = '-';
            }
            else if(s.charAt(i) == '+') {
                type = '+';
            }
            else if(s.charAt(i) == '(') {
                int[] nums = sol(s,i + 1);
                if(type == '+') {
                  sum = sum + nums[0];
                }
                else {
                    sum= sum - nums[0];
                }
                i = nums[1];
            }
            else if(s.charAt(i) == ')') {
               return new int[]{sum,i};
            }
        }
        return new int[]{sum,0};
    }
}
