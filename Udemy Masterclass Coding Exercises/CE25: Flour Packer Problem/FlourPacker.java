/* This coding exercise differs from the others in that there are truly multiple approaches to solving this rather
than simply refactoring by changing syntax or format.  The "simplest" solution to come up with is using "brute force"
with nested loops, but this is not concise nor performant.  Alternative approaches uses modulo, Math.min(), as well
as recursion.  Understanding how each approach works will really solidify your Java fundamentals. */


/* Basic solution, using "brute force" with nested loops (not performant, quadratic time complexity).
Note that the nested loops will validate bigCount and smallCount. */
public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (goal < 0) {
            return false;
        }
        for (int i = 0; i <= bigCount; i++) {
            for (int j = 0; j <= smallCount; j++) {
                if (i*5 + j == goal) {
                    return true;
                } 
            }
        }
        return false;
    }
}


/* Alternative solution using linear time complexity with 2 separate while loops.  This approach
subtracts 5 from goal for each bigCount and subtracts 1 for each smallCount.  If the remaining
goal is 0, then return true. */
public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (goal < 0) {
            return false;
        }
  
        while (goal >= 5 && bigCount > 0) { // linear time complexity
            goal -= 5; // subtract 5 from goal for each bigCount
            bigCount--; // decrement bigCount by 1 for each iteration
        }
    
        while (goal > 0 && smallCount > 0) { // linear time complexity
            goal -= 1; // subtract 1 from goal for each smallCount
            smallCount--;
        }
        
        return goal == 0;
    }
}


/* Alternative solution without while loop for smallCount and use direct comparison of "remaining" goal
with smallCount, since smallCount is 1 bag of flour. */
public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (goal < 0) {
            return false;
        }
  
        while (goal >= 5 && bigCount > 0) { // linear time complexity
            goal -= 5; // subtract 5 from goal for each bigCount
            bigCount--; // decrement bigCount by 1 for each iteration
        }

        return goal <= smallCount; // "remaining" goal has to be less than or equal to smallCount
    }
}


/* Alternative solution without loops, using modulo to get "remaining" goal (constant time complexity).
Note, this approach will require a validation of supply vs demand first before using modulo %5 to get
the remaining goal to compare to smallCount. */
public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (goal >= 0) {
            if (bigCount*5 + smallCount >= goal) { // supply vs demand
                return goal%5 <= smallCount; // "remaining" goal has to be less than or equal to smallCount
            }
        }
        return false;
    }
}


// Alternative solution using modulo to get "remaining" goal as single-line return statement
public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        return goal >= 0 && bigCount*5 + smallCount >= goal && goal%5 <= smallCount;
    }
}


// Alternative solution using ternary operator to find smallCount needed, i.e. remaining goal after removing bigCount
public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (goal < 0) {
            return false;
        }

        int smallNeeded = goal/5 <= bigCount ? goal%5 : goal - bigCount*5;
        return smallNeeded <= smallCount;
    }
}


/* Alternative solution using Math.min() to determine how much bigCount if all or just some will actually be used,
and similarly for smallCount if all or some will actually be used. */
public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (goal >= 0) {
            int bigUsed = Math.min(bigCount, goal/5);
            int smallUsed = Math.min(smallCount, goal - (bigUsed*5));
            return (bigUsed*5 + smallUsed) == goal;
        }
        return false;
    }
}


// Alternative solution using recursion
public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        return goal == 0 || canPack(bigCount-1, smallCount, goal-5) || canPack(0, smallCount-1, goal-1);
    }
}