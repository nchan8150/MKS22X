public class Recursion {

    public int fact(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return 1;
	}
	return n * fact(n - 1);
    }
    
    public int fib(int n) {
	return fibHelp(n, 0, 0, 1);
    }

    public int fibHelp(int n, int count, int twoBefore, int oneBefore) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == count) {
	    return twoBefore;
	}
	return fibHelp(n, count + 1, oneBefore, oneBefore + twoBefore);  
    }

    public double sqrt(double n) {
	return sqrtHelp(n, n / 2);
    }

    public double sqrtHelp(double n, double guess) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return 0;
	}
	if (((n * 1.000001) > (guess * guess)) && ((n * 0.99999) < (guess * guess))) {
	    return guess;
	}
	return sqrtHelp(n, (n / guess + guess) / 2);
    }
    /*
    public static void main(String[] args) {
	System.out.println(fact(0)); //should be 1
	System.out.println(fact(5)); //should be 120
	//System.out.println(fact(-50)); //error
	System.out.println(fib(0)); //should be 0
	System.out.println(fib(1)); //should be 1
	System.out.println(fib(6)); //should be 8
	//System.out.println(fib(1000));
	//System.out.println(fib(-50)); //error
	System.out.println(sqrt(0)); //should be 0
	System.out.println(sqrt(1)); //should be 1
	System.out.println(sqrt(4)); //should be 2
	System.out.println(sqrt(.1111111)); //should be .3333333
	System.out.println(sqrt(10)); //should be 3.16
	//System.out.println(sqrt(-4)); //error
			   
    }
    */
}
    
    
