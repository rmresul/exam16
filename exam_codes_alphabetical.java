// EXAM CODES — SORTED ALPHABETICALLY
// ====================================


// 1. ANAGRAM DETECTION (#2)
HashMap<Character, Integer> map = new HashMap<>();
for (char c : s1.toCharArray())
    map.put(c, map.getOrDefault(c, 0) + 1);
for (char c : s2.toCharArray())
    map.put(c, map.getOrDefault(c, 0) - 1);
for (int v : map.values())
    if (v != 0)
        return false;
return true;


// 2. ATM PAYMENT (#3)
List<String> note = new ArrayList<>();
for(int n : new int[]{100,50,20,10,5,1}){
    while(amount>=n){
        note.add(String.valueOf(n));
        amount-=n;
    }
}
return String.join(",",note);


// 3. BACTERIAL SIMULATION (#42)
List<Integer> a=new ArrayList<>(List.of(0));
while(t-->0){
    List<Integer> b=new ArrayList<>();
    for(int x:a){
        x++;
        if(x>=l) continue;
        if(x%m==0){ b.add(0); b.add(0); }
        else b.add(x);
    }
    a=b;
}
return a.size();


// 4. BALANCED BINARY TREE (#28)
public static boolean isBalanced(TreeNode root) {
    return height(root) != -1;
}
static int height(TreeNode n) {
    if (n == null) return 0;
    int l = height(n.left);
    int r = height(n.right);
    return (l==-1 && r==-1) ? -1 : Math.abs(l - r) > 1 ? -1 : 1 + Math.max(l, r);
}


// 5. BST VALIDATION (#43)
public static boolean isValidBST(TreeNode root) {
    return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
private static boolean check(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return check(node.left, min, node.val) && check(node.right, node.val, max);
}


// 6. BUBBLE SORT (#16)
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j].getValue() > arr[j + 1].getValue()) {
            IntTracker temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}


// 7. BUILDING THE QUEUE STRUCT (#7)
int[] a = new int[1000];
int f = 0, r = 0;
public void enqueue(int x) { a[r++] = x; }
public int dequeue() { return f == r ? -1 : a[f++]; }
public int peek() { return f == r ? -1 : a[f]; }


// 8. CAESAR CIPHER (#9)
char[] arr = s.toCharArray();
for(int i = 0; i < s.length(); i++){
    char c=arr[i];
    if(c >= 'a' && c <= 'z') arr[i] = (char)('a' + (c - 'a' + shift) % 26);
    else if(c >= 'A' && c <= 'Z') arr[i] = (char)('A' + (c - 'A' + shift) % 26);
}
return new String(arr);


// 9. CELLULAR AUTOMATON 1D (#31)
int[] res = new int[cells.length];
for (int i = 0; i < cells.length; i++) {
    res[i] = (i > 0 ? cells[i - 1] : 0) ^ (i < cells.length - 1 ? cells[i + 1] : 0);
}
return res;


// 10. CHECKING STRONG PASSWORD CRITERIA (#15)
return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");


// 11. CIRCULAR ARRAY BACKWARD SUM (#14)
int sum = 0, n = data.length;
for (int i = 0; i < n; i++)
    sum += data[(startIndex - i + n) % n];
return sum;


// 12. DEPTH OF A NODE IN A BINARY TREE (#33)
if (root == null) return -1;
if (root.val == target) return 0;
int l = getDepth(root.left, target);
int r = getDepth(root.right, target);
return (l == -1 && r == -1) ? -1 : 1 + Math.max(l, r);


// 13. DUPLICATING ARRAY ELEMENTS BY VALUE (#40)
int size = 0;
for (int i = 0; i < nums.size(); i++) size += nums.get(i);
int[] result = new int[size];
int k = 0;
for (int i = 0; i < nums.size(); i++) {
    int val = nums.get(i);
    for (int j = 0; j < val; j++) result[k++] = val;
}
return result;


// 14. FINDING FIRST UNIQUE CHARACTER (#10)
int[] arr = new int[256];
for(int c : s.toCharArray()) arr[c]++;
for(int i = 0; i < s.length(); i++){
    if(arr[s.charAt(i)] == 1) return i;
}
return -1;


// 15. FINDING HIGHEST-VALUE ELEMENTS TOP-K (#27)
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
for (int num : nums) pq.add(num);
List<Integer> result = new ArrayList<>();
for (int i = 0; i < k; i++) result.add(pq.poll());
return result;


// 16. FINDING MAXIMUM DEGREE OF A GENERAL TREE (#26)
if (root == null) return 0;
int m = root.children.size();
for (Node c : root.children)
    m = Math.max(m, getMaxDegree(c));
return m;


// 17. FINDING MEDIAN OF AN ARRAY (#12)
Arrays.sort(arr);
int n = arr.length;
return n % 2 != 0 ? arr[n / 2] : (arr[n / 2 - 1] + arr[n / 2]) / 2.0;


// 18. FINDING POINTS CLOSEST TO A TARGET (#25)
PriorityQueue<Integer> pq = new PriorityQueue<>(
    (a, b) -> Math.abs(a - target) - Math.abs(b - target));
for (int num : nums) pq.add(num);
List<Integer> result = new ArrayList<>();
for (int i = 0; i < k; i++) result.add(pq.poll());
return result;


// 19. FINDING WORDS ON THE SAME KEYBOARD ROW (#23)
return Arrays.stream(words)
    .filter(w -> w.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
    .toArray(String[]::new);


// 20. FULL BINARY TREE CHECK (#37)
if (root == null) return true;
if ((root.left == null) != (root.right == null)) return false;
return isFullTree(root.left) && isFullTree(root.right);


// 21. GAS STATION (#1)
int tank=0, total=0, start=0;
for(int i=0; i< gas.length; i++){
    tank+=gas[i]-cost[i];
    total+=gas[i]-cost[i];
    if(tank<0){ start=1+i; tank=0; }
}
return total<0 ? -1 : start;


// 22. GENERATING PASCAL'S TRIANGLE (#36)
List<List<Integer>> result = new ArrayList<>();
for (int i = 0; i < numRows; i++) {
    List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
    for (int j = 1; j < i; j++)
        row.set(j, result.get(i-1).get(j-1) + result.get(i-1).get(j));
    result.add(row);
}
return result;


// 23. HEIGHT OF A NODE IN A BINARY TREE (#35)
return root == null ? 0 : 1 + Math.max(getNodeHeight(root.left), getNodeHeight(root.right));


// 24. HEXADECIMAL FROM BINARY SIGNALS (#13)
int v = 0;
for (boolean b : bits) v = v * 2 + (b ? 1 : 0);
return "0123456789ABCDEF".charAt(v);


// 25. INSERTION SORT (#18)
for (int i = 1; i < arr.length; i++) {
    for (int j = i; j > 0; j--) {
        if (arr[j].getValue() < arr[j - 1].getValue()) {
            IntTracker temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
        } else break;
    }
}


// 26. INTERSECTION OF TWO ARRAYS (#19)
Arrays.sort(arr2);
return Arrays.stream(arr1)
    .filter(x -> Arrays.binarySearch(arr2, x) >= 0)
    .distinct()
    .sorted()
    .toArray();


// 27. JOSEPHUS / SURVIVING PERSON IN A CIRCLE (#29)
int r=0;
for(int i=1;i<=n;i++) r=(r+k)%i;
return r+1;


// 28. LINKED LIST: FINDING MIDDLE (#8)
Node slow = head, fast = head;
while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
}
return (slow != null) ? slow.data : -1;


// 29. LONGEST COMMON PREFIX (#11)
if(strs == null) return "";
String first = strs[0];
for(String s : strs)
    while(!s.startsWith(first))
        first = first.substring(0, first.length() - 1);
return first;


// 30. MAXIMUM DIFFERENCE FINDING (#32)
Arrays.sort(nums);
int n = nums.length;
return (nums[n - 1] * nums[n - 2]) - (nums[0] * nums[1]);


// 31. MERGING INTERSECTING SEGMENTS (#22)
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
int k = 0;
for (int[] i : intervals)
    if (intervals[k][1] >= i[0]) intervals[k][1] = Math.max(intervals[k][1], i[1]);
    else intervals[++k] = i;
return Arrays.copyOf(intervals, k + 1);


// 32. PASSWORD COMBINATION GENERATION (#39)
static class SafeTask {
    public List<String> findCodes(String digits, int length) {
        List<String> res = new ArrayList<>();
        generate(digits, length, "", res);
        return res;
    }
    private void generate(String digits, int length, String current, List<String> res) {
        if (current.length() == length) { res.add(current); return; }
        for (char c : digits.toCharArray())
            generate(digits, length, current + c, res);
    }
}


// 33. REVERSING WORDS IN A STRING (#20)
String[] w = s.trim().split("\\s+");
Collections.reverse(Arrays.asList(w));
return String.join(" ", w);


// 34. ROMAN NUMERAL TO INTEGER (#21)
public static int romanToInt(String s) {
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
        int cur = value(s.charAt(i));
        int next = i + 1 < s.length() ? value(s.charAt(i + 1)) : 0;
        if (cur < next) sum -= cur;
        else sum += cur;
    }
    return sum;
}
private static int value(char c) {
    switch (c) {
        case 'I': return 1;   case 'V': return 5;
        case 'X': return 10;  case 'L': return 50;
        case 'C': return 100; case 'D': return 500;
        case 'M': return 1000; default: return 0;
    }
}


// 35. ROOT-TO-LEAF PATH SUM (#34)
if (root==null) return false;
if(root.right==null && root.left==null) return targetSum == root.val;
return rootToLeafSum(root.left, targetSum - root.val) || rootToLeafSum(root.right, targetSum - root.val);


// 36. RUN-LENGTH ENCODING TEXT COMPRESSION (#38)
int write = 0, i = 0;
while (i < chars.length) {
    char currentChar = chars[i];
    int count = 0;
    while (i < chars.length && chars[i] == currentChar) { i++; count++; }
    chars[write++] = currentChar;
    if (count > 1)
        for (char c : Integer.toString(count).toCharArray())
            chars[write++] = c;
}
return write;


// 37. SELECTION SORT (#17)
for (int i = 0; i < arr.length - 1; i++) {
    int min = i;
    for (int j = i + 1; j < arr.length; j++)
        if (arr[j].getValue() < arr[min].getValue()) min = j;
    IntTracker temp = arr[i];
    arr[i] = arr[min];
    arr[min] = temp;
}


// 38. SORTING RECTANGLES BY AREA (#30)
Arrays.sort(rectangles,(x,y)->x[0]*x[1]-y[0]*y[1]);
return rectangles;


// 39. STACK: PARENTHESIS BALANCE (#4)
int c=0;
for(int i=0; i < s.length(); i++){
    if(s.charAt(i) == '(') c++;
    else if (--c < 0) return false;
}
return c == 0;


// 40. TEEMO ATTACK (#5)
int total=0;
for(int i=0; i<timeSeries.length-1; i++){
    int gap = timeSeries[i+1] - timeSeries[i];
    if(gap >= duration) total += duration;
    else total += gap;
}
return duration + total;


// 41. TOKEN GAME: MAXIMUM SCORE (#41)
Arrays.sort(tokens);
int l = 0, r = tokens.length - 1, score = 0;
while (l <= r)
    if (power >= tokens[l]) { power -= tokens[l++]; score++; }
    else if (score > 0 && l < r) { power += tokens[r--]; score--; }
    else break;
return score;


// 42. TRAVEL ROUTE RESTORATION (#44)
Map<String, String> map = new HashMap<>();
for (String[] t : tickets) map.put(t[0], t[1]);
Set<String> start = new HashSet<>(map.keySet());
start.removeAll(map.values());
List<String> res = new ArrayList<>();
for (String s = start.iterator().next(); s != null; s = map.get(s)) res.add(s);
return res.toArray(new String[0]);


// 43. TRIANGLE WITH MAXIMUM PERIMETER (#24)
Arrays.sort(nums);
for (int i = nums.length - 1; i >= 2; i--)
    if (nums[i - 2] + nums[i - 1] > nums[i])
        return nums[i - 2] + nums[i - 1] + nums[i];
return 0;


// 44. VALIDATING A MOUNTAIN ARRAY (#6)
int n=arr.length;
int i=0;
while(i < n-1 && arr[i] < arr[i+1]) i++;
if(i == 0 || i == n-1) return false;
while(i < n-1 && arr[i] > arr[i+1]) i++;
return i == n-1;
