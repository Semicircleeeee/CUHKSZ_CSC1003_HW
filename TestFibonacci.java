import java.util.*;

public class TestFibonacci {

    static Scanner input = new Scanner(System.in);

    // here is the function you need to implement
	public static void parse_line(int n, int d) {
        if (d == 0){System.out.print(" ");}
    else {if (n < d) 
    {
         System.out.print("invalid");
    }
    if (n >= d) 
    {
     int args[] = new int[n];
    args[0] = 1;
    args[1] = 1;
        for ( int a = 2; a < n; a++)
        {
        args[a] = args[a-1] + args[a-2];
        }
        for ( int b = n-1; b > n-d-1; b-- )
       {
        if( b > n-d)
            {
                 System.out.print(args[b] + ", ");
            }
        if( b == n-d)
             System.out.print(args[b]);
       }
       }
    }
    System.out.print("\n");
}

    public static void main(String[] args) throws Exception {
        int line_number = Integer.parseInt(input.nextLine()); 
        for(int i=0; i<line_number; i++) {
            String s = input.nextLine();
            String t[] = s.split(", ");
            int n = Integer.parseInt(t[0]);
            int d = Integer.parseInt(t[1]);
            TestFibonacci.parse_line(n, d);
        }
    }
}