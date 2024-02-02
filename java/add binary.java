O(max(N, M))
O(max(N, M))

class Solution 
{
  public String addBinary(String a, String b) 
  {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;

    while (i >= 0 || j >= 0 || carry == 1) 
    {
      if(i >= 0)
        carry += a.charAt(i--) - '0';
      if(j >= 0)
        carry += b.charAt(j--) - '0';
      sb.append(carry % 2);
      carry /= 2;
    }
    return sb.reverse().toString();
  }
}

a = "1010"
b = "1011"

if sum is 0 res is 0 and carry is 0
if sum is 1 res is 1 and carri is 0
if sum is 2 res is 0 and carry is 1
if sum is 3 res is 1 and carry is 1

i = 4 - 1 = 3
j = 4 - 1 = 3

FIRST ITERACTION
carry = 0 (carry) + '0' (digitA) - '0' = 0 -> i = 2
carry = 0 + '1' (digitB) - '0' = 1 -> j = 2
sb = 1 (carry) % 2 = "1"
carry = 1 / 2 = 0

SECOND ITERACTION
carry = 0 + '1' - '0' = 1 -> i = 1
carry = 1 + '1' - '0' = 2 -> j = 1
sb = 2 % 2 = "01"
carry = 2/2 = 1

THIRD ITERACTION
carry = 1 + '0' - '0' = 1 -> i = 0
carry = 1 + '0' - '0' = 1 -> j = 0
sb = 1 % 2 = "101"
carry = 1/2 = 0

FOURTH ITERACTION
carry = 0 + '1' - '0' = 1 -> i = -1
carry = 1 + '1' - '0' = 2 -> j = -1
sb = 2 % 2 = "0101"
carry = 2/2 = 1

FIFTH ITERACTION
sb = 1 % 2 = "10101"
carry 1/2 = 0

return sb.reverse = "10101"
