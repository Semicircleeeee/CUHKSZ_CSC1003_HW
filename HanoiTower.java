import java.util.*;
public class HanoiTower{
  public static String move(int a,int b,int c,int d){
    if(a==0)return "";
    else{
    String step;
    step=b+"->"+c+"\n";
    return move(a-1,b,d,c)+step+move(a-1,d,c,b);}
    }
  public static void main(String args[]){
  Scanner input=new Scanner(System.in);
  int m=input.nextInt();
  int n=input.nextInt();
  int p=input.nextInt();
  int o=input.nextInt();
  StringBuffer a=new StringBuffer(move(m,n,p,o));
  System.out.print(a);
}
}