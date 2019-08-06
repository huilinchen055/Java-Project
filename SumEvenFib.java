public class SumEvenFib {
    public static int fib(int n) {
        if (n<=1)
            return n;
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        long sum = 0;
        int i =1;
        while (fib(i) <4000000)
        {if (fib(i) % 2 ==0)
            {sum = sum + fib(i);}
            i++;}
        System.out.println(sum);
    }
}
