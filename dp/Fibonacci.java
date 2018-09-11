/*
https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
 */
public class Fibonacci {

    public int bottomUp(int n) {
        if (n <= 1) {
            return n;
        }

        int fib[] = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    public int topDown(int n) {
        if (n <= 1) {
            return n;
        }

        int cache[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            cache[i] = -1;
        }

        return fib(n, cache);
    }

    private int fib(int n, int[] cache) {
        if (cache[n] == -1) {
            if (n <= 1) {
                cache[n] = n;
            } else {
                cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
            }
        }

        return cache[n];
    }
}
