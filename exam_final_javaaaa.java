
// 1. 1D CELLULAR AUTOMATON 
public static int[] gameOfLife1D(int[] cells) {
    int[] res = new int[cells.length];
    for (int i = 0; i < cells.length; i++) {
        res[i] = (i > 0 ? cells[i - 1] : 0) ^ (i < cells.length - 1 ? cells[i + 1] : 0);
    }
    return res;
}

// ==========================================

// 2. ANAGRAM DETECTION 
static class HashTask {
    public boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : s2.toCharArray())
            map.put(c, map.getOrDefault(c, 0) - 1);
        for (int v : map.values())
            if (v != 0)
                return false;
        return true;
    }
}

// ==========================================

// 3. ATM PAYMENT 
static class ATMTask {
    public String calculateATM(int a) {
        List<String> note = new ArrayList<>();
        for (int n : new int[]{100, 50, 20, 10, 5, 1}) {
            while (a >= n) {
                note.add(String.valueOf(n));
                a -= n;
            }
        }
        return String.join(",", note);
    }
}

// ==========================================

// 4. BACTERIAL SIMULATION 
public static int simulateBacteria(int m, int l, int t) {
    List<Integer> a = new ArrayList<>(List.of(0));
    while (t-- > 0) {
        List<Integer> b = new ArrayList<>();
        for (int x : a) {
            x++;
            if (x >= l) continue;
            if (x % m == 0) { b.add(0); b.add(0); }
            else b.add(x);
        }
        a = b;
    }
    return a.size();
}

// ==========================================

// 5. BALANCED BINARY TREE 
public static boolean isBalanced(TreeNode root) {
    return height(root) != -1;
}
static int height(TreeNode n) {
    if (n == null) return 0;
    int l = height(n.left);
    int r = height(n.right);
    return (l == -1 && r == -1) ? -1 : Math.abs(l - r) > 1 ? -1 : 1 + Math.max(l, r);
}

// ==========================================

// 6. BUBBLE SORT 
public static void sort(IntTracker[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j].getValue() > arr[j + 1].getValue()) {
                IntTracker temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

// ==========================================

// 7. BUILDING THE QUEUE STRUCT 
static class MyQueue {
    int[] a = new int[1000];
    int f = 0, r = 0;
    public void enqueue(int x) { a[r++] = x; }
    public int dequeue() { return f == r ? -1 : a[f++]; }
    public int peek() { return f == r ? -1 : a[f]; }
}

// ==========================================

// 8. CAESAR CIPHER 
static class Task {
    public String encrypt(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = arr[i];
            if (c >= 'a' && c <= 'z') arr[i] = (char)('a' + (c - 'a' + k) % 26);
            else if (c >= 'A' && c <= 'Z') arr[i] = (char)('A' + (c - 'A' + k) % 26);
        }
        return new String(arr);
    }
}

// ==========================================

// 9. CHECKING A BINARY SEARCH TREE BST 
public static boolean isValidBST(TreeNode root) {
    return dfs(root, null, null);
}
static boolean dfs(TreeNode n, Integer min, Integer max) {
    if (n == null) return true;
    if (min != null && n.val <= min) return false;
    if (max != null && n.val >= max) return false;
    return dfs(n.left, min, n.val) && dfs(n.right, n.val, max);
}

// ==========================================

// 10. CHECKING A FULL BINARY TREE
public static boolean isFullTree(TreeNode root) {
    if (root == null) return true;
    if ((root.left == null) != (root.right == null)) return false;
    return isFullTree(root.left) && isFullTree(root.right);
}

// ==========================================

// 11. CHECKING STRONG PASSWORD CRITERIA 
return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");

// ==========================================

// 12. CONVERSATION OF ROMAN NUMERALS OF INTEGERS 
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

// ==========================================

// 13. THE DEPTH OF A NODE IN A BINARY TREE 
public static int getDepth(TreeNode root, int target) {
    if (root == null) return -1;
    if (root.val == target) return 0;
    int l = getDepth(root.left, target);
    int r = getDepth(root.right, target);
    return (l == -1 && r == -1) ? -1 : 1 + Math.max(l, r);
}

// ==========================================

// 14. DUPLICATING ARRAY ELEMENTS BY VALUE 
public static int[] expandArray(IntTracker nums) {
    int size = 0;
    for (int i = 0; i < nums.size(); i++) size += nums.get(i);
    int[] result = new int[size];
    int k = 0;
    for (int i = 0; i < nums.size(); i++) {
        int val = nums.get(i);
        for (int j = 0; j < val; j++) result[k++] = val;
    }
    return result;
}

// ==========================================

// 15. FINDING THE FIRST UNIQUE CHARACTER 
static class StringTask {
    public int firstUniqChar(String s) {
        int[] arr = new int[256];
        for (int c : s.toCharArray()) arr[c]++;
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] == 1) return i;
        }
        return -1;
    }
}

// ==========================================

// 16. FINDING THE HIGHEST-VALUE ELEMENTS TOP-K 
static class PriorityTask {
    public List<Integer> getTopK(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) pq.add(num);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) result.add(pq.poll());
        return result;
    }
}

// ==========================================

// 17. FINDING THE MAXIMUM DEGREE OF A GENERAL TREE 
public static int getMaxDegree(Node root) {
    if (root == null) return 0;
    int m = root.children.size();
    for (Node c : root.children)
        m = Math.max(m, getMaxDegree(c));
    return m;
}

// ==========================================

// 18. FINDING THE MEDIAN OF AN ARRAY 
public static double findMedian(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    return n % 2 != 0 ? arr[n / 2] : (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
}

// ==========================================

// 19. FINDING THE POINTS CLOSEST TO A TARGET 
static class PriorityTask {
    public List<Integer> findClosest(int[] nums, int k, int target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Math.abs(a - target) - Math.abs(b - target));
        for (int num : nums) pq.add(num);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) result.add(pq.poll());
        return result;
    }
}

// ==========================================

// 20. FINDING WORDS ON THE SAME KEYBOARD ROW 
public static String[] findWords(String[] words) {
    return Arrays.stream(words)
        .filter(w -> w.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
        .toArray(String[]::new);
}

// ==========================================

// 21. GAS STATION 
static class Task {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, total = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (tank < 0) { start = 1 + i; tank = 0; }
        }
        return total < 0 ? -1 : start;
    }
}

// ==========================================

// 22. GENERATING PASCAL'S TRIANGLE 
static class Task {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            for (int j = 1; j < i; j++)
                row.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            result.add(row);
        }
        return result;
    }
}

// ==========================================

// 23. THE HEIGHT OF A NODE IN A BINARY TREE 
public static int getNodeHeight(TreeNode root) {
    return root == null ? 0 : 1 + Math.max(getNodeHeight(root.left), getNodeHeight(root.right));
}

// ==========================================

// 24. INSERTION SORT 
public static void sort(IntTracker[] arr) {
    for (int i = 1; i < arr.length; i++) {
        for (int j = i; j > 0; j--) {
            if (arr[j].getValue() < arr[j - 1].getValue()) {
                IntTracker temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            } else break;
        }
    }
}

// ==========================================

// 25. INTERSECTION OF TWO ARRAYS 
public static int[] intersection(int[] arr1, int[] arr2) {
    Arrays.sort(arr2);
    return Arrays.stream(arr1)
        .filter(x -> Arrays.binarySearch(arr2, x) >= 0)
        .distinct()
        .sorted()
        .toArray();
}

// ==========================================

// 26. LINKED LIST: FINDING MIDDLE
static class MiddleNodeTask {
    public int findMiddle(Node h) {
        Node slow = h, fast = h;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (slow != null) ? slow.data : -1;
    }
}

// ==========================================

// 27. LONGEST COMMON PREFIX
static class Task {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";
        String first = strs[0];
        for (String s : strs)
            while (!s.startsWith(first))
                first = first.substring(0, first.length() - 1);
        return first;
    }
}

// ==========================================

// 28. MAXIMUM DIFFERENCE FINDING 
public static int maxProductDifference(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    return (nums[n - 1] * nums[n - 2]) - (nums[0] * nums[1]);
}

// ==========================================

// 29. MERGING INTERSECTING SEGMENTS 
public static int[][] mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int k = 0;
    for (int[] i : intervals)
        if (intervals[k][1] >= i[0]) intervals[k][1] = Math.max(intervals[k][1], i[1]);
        else intervals[++k] = i;
    return Arrays.copyOf(intervals, k + 1);
}

// ==========================================

// 30. OBTAINING HEXADECIMAL CHARACTERS FROM BINARY SIGNALS 
public static char convertToHexChar(boolean[] bits) {
    int v = 0;
    for (boolean b : bits) v = v * 2 + (b ? 1 : 0);
    return "0123456789ABCDEF".charAt(v);
}

// ==========================================

// 31. PASSWORD COMBINATION GENERATION
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

// ==========================================

// 32. RESTORATION OF UNIQUE TRAVEL
public static String[] reconstructItinerary(String[][] tickets) {
    Map<String, String> map = new HashMap<>();
    for (String[] t : tickets) map.put(t[0], t[1]);
    Set<String> start = new HashSet<>(map.keySet());
    start.removeAll(map.values());
    List<String> res = new ArrayList<>();
    for (String s = start.iterator().next(); s != null; s = map.get(s)) res.add(s);
    return res.toArray(new String[0]);
}

// ==========================================

// 33. REVERSING WORDS IN A STRING 
public static String reverseWords(String s) {
    String[] w = s.trim().split("\\s+");
    Collections.reverse(Arrays.asList(w));
    return String.join(" ", w);
}

// ==========================================

// 34. ROOT-TO-LEAF PATH SUM 
public static boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.right == null && root.left == null) return sum == root.val;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}

// ==========================================

// 35. SELECTION SORT 
public static void sort(IntTracker[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int min = i;
        for (int j = i + 1; j < arr.length; j++)
            if (arr[j].getValue() < arr[min].getValue()) min = j;
        IntTracker temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}

// ==========================================

// 36. SORTING RECTANGLES BY AREA 
public static int[][] sortRectangles(int[][] a) {
    Arrays.sort(a, (x, y) -> x[0] * x[1] - y[0] * y[1]);
    return a;
}

// ==========================================

// 37. STACK: PARENTHESIS BALANCE 
static class BracketTask {
    public boolean isBalanced(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') c++;
            else if (--c < 0) return false;
        }
        return c == 0;
    }
}

// ==========================================

// 38. SUM OF BACKWARD SIGNALS
public static int calculateCircularSum(int[] a, int s) {
    int sum = 0, n = a.length;
    for (int i = 0; i < n; i++)
        sum += a[(s - i + n) % n];
    return sum;
}

// ==========================================

// 39. SURVIVING PERSON IN A CIRCLE 
public static int findTheWinner(int n, int k) {
    int r = 0;
    for (int i = 1; i <= n; i++) r = (r + k) % i;
    return r + 1;
}

// ==========================================

// 40. TEEMO ATTACK 
static class Task {
    public int findPoisonedDuration(int[] t, int d) {
        int total = 0;
        for (int i = 0; i < t.length - 1; i++) {
            int gap = t[i + 1] - t[i];
            if (gap >= d) total += d;
            else total += gap;
        }
        return d + total;
    }
}

// ==========================================

// 41. TEXT COMPRESSION RUN-LENGTH ENCODING
static class Task {
    public int compress(char[] c) {
        int write = 0, i = 0;
        while (i < c.length) {
            char currentChar = c[i];
            int count = 0;
            while (i < c.length && c[i] == currentChar) { i++; count++; }
            c[write++] = currentChar;
            if (count > 1)
                for (char x : Integer.toString(count).toCharArray())
                    c[write++] = x;
        }
        return write;
    }
}

// ==========================================

// 42. TOKEN GAME: MAXIMUM SCORE 
public static int bagOfTokensScore(int[] tokens, int power) {
    Arrays.sort(tokens);
    int l = 0, r = tokens.length - 1, score = 0;
    while (l <= r)
        if (power >= tokens[l]) { power -= tokens[l++]; score++; }
        else if (score > 0 && l < r) { power += tokens[r--]; score--; }
        else break;
    return score;
}

// ==========================================

// 43. TRIANGLE WITH MAXIMUM PERIMETER 
public static int largestPerimeter(int[] a) {
    Arrays.sort(a);
    for (int i = a.length - 1; i >= 2; i--)
        if (a[i - 2] + a[i - 1] > a[i])
            return a[i - 2] + a[i - 1] + a[i];
    return 0;
}

// ==========================================

// 44. VALIDATING A MOUNTAIN ARRAY 
static class Task {
    public boolean validMountainArray(int[] a) {
        int n = a.length;
        int i = 0;
        while (i < n - 1 && a[i] < a[i + 1]) i++;
        if (i == 0 || i == n - 1) return false;
        while (i < n - 1 && a[i] > a[i + 1]) i++;
        return i == n - 1;
    }
}
