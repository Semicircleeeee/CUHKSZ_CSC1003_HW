import java.util.*;
public class TestMathExpr{
    public static String[] deletebrackets(String[] a){
      int l=0,r=0,end=0;
      for(int i=0;i<a.length;i++){
        if(a[i]==null||i==a.length-1){return a;}
        if(a[i].equals("(")){break;}
      }
      for(int i=0;i<a.length;i++){
        if(a[i]==null){end=i;break;}
        else{end=a.length;}
      }
      if(end==1){return a;}
      for(int i=0;i<end;i++){
        if(a[i].equals("(")==true&&checknumber(a[i+1])==true&&a[i+2].equals(")")==true)
        {a[i]=null;
        a[i+2]=null;
        a=cleanBlank(a);
        return deletebrackets(a);}
        else if(a[i].equals("(")){l=i+1;continue;}
        else if(a[i].equals(")")){r=i-1;break;}
      }
      String[] b=new String[a.length];
      for(int i=0,j=l;i<r-l+1;i++,j++){
      b[i]=a[j];
      }
      b=calculate3(b);
      b=calculate1(b);
      b=calculate2(b);
      a[l-1]=b[0];for(int i=l;i<=r+1;i++){a[i]=null;}
      a=cleanBlank(a);
      return deletebrackets(a);
      }
    public static String[] combine(String[] a){
      for(int i=0;i<a.length;i++){
        if(a[i]==null){return a;}
        else if(a[i].equals("-")&&checknumber(a[i-1])==false&&checknumber(a[i+1])==true&&a[i-1].equals(")")==false){
            a[i]=String.valueOf(-Double.valueOf(a[i+1]));
            a[i+1]=null;
            a=cleanBlank(a);
        }}
      return a;
    }
    public static String[] cleanBlank(String[] a){
      for(int i=0;i<a.length;i++){
        if(a[i]==null&&i!=a.length-1){
         for(int j=i+1;j<a.length;j++){
            if(a[j]!=null){
                a[i]=a[j];a[j]=null;break;}}}}
      return a;
    }
    public static boolean checknumber(String a){
     if(a.matches("(-)?\\d+(\\.?\\d+)?"))return true;
     else return false;
    }
    public static String[] calculate1(String[] a){
      for(int i=0;i<a.length;i++){
        if(a[i]==null)break;
        else {
        if(a[i].equals("*")){
            a[i]=String.valueOf((double)(Double.valueOf(a[i-1])*Double.valueOf(a[i+1])));a[i-1]=null;a[i+1]=null;a=cleanBlank(a);return calculate1(a);}
        else if(a[i].equals("/"))
            {
            a[i]=String.valueOf((double)(Double.valueOf(a[i-1])/Double.valueOf(a[i+1])));a[i-1]=null;a[i+1]=null;a=cleanBlank(a);return calculate1(a);}
      }}
      return a;
      }
    public static String[] calculate2(String[] a){
      for(int i=0;i<a.length;i++){
        if(a[i]==null)break;
        else {
        if(a[i].equals("+")){
            a[i]=String.valueOf((double)(Double.valueOf(a[i-1])+Double.valueOf(a[i+1])));a[i-1]=null;a[i+1]=null;a=cleanBlank(a);return calculate2(a);}
        else if(a[i].equals("-"))
            {a[i]=String.valueOf((double)(Double.valueOf(a[i-1])-Double.valueOf(a[i+1])));a[i-1]=null;a[i+1]=null;a=cleanBlank(a);return calculate2(a);}
      }}
      return a;
      }
    public static String[] calculate3(String[] a){
      for(int i=0;i<a.length;i++){
        if(a[i]==null)break;
        else {
        if(a[i].equals("s")){
            a[i]=String.valueOf(Math.sin(Double.valueOf(a[i+1])));a[i+1]=null;a=cleanBlank(a);return calculate3(a);}
        else if(a[i].equals("c")){
            a[i]=String.valueOf(Math.cos(Double.valueOf(a[i+1])));a[i+1]=null;a=cleanBlank(a);return calculate3(a);}
        else if(a[i].equals("t")){
            a[i]=String.valueOf(Math.tan(Double.valueOf(a[i+1])));a[i+1]=null;a=cleanBlank(a);return calculate3(a);}
        else if(a[i].equals("q")){
            a[i]=String.valueOf(Math.sqrt(Double.valueOf(a[i+1])));a[i+1]=null;a=cleanBlank(a);return calculate3(a);}                             
      }}
      return a;
      }  
    public static double parse(String str){
      str=str.replaceAll(" ", "");
      str=str.replaceAll("sin", "s");
      str=str.replaceAll("cos", "c");
      str=str.replaceAll("tan", "t");
      str=str.replaceAll("sqrt","q");
      if(str.charAt(0)=='-'){str="0"+str;}
      String[] whole=new String[str.length()];
      boolean[] light=new boolean[str.length()];
      for(int i=0;i<str.length();i++){
       if(str.substring(i, i+1).matches("[^0-9]")){
        if(str.substring(i, i+1).equals(".")==false){
           whole[i]=str.substring(i, i+1);
           light[i]=true;}
        if(str.substring(i, i+1).matches("\\.")){
        int l=0, r=0;
      for(int j=i;j>=0;j--){
            if(j==0){l=j;break;}
            else if((str.substring(j-1,j).matches("[0-9]")==false)){l=j;break;}
        }
      for(int j=i;j<str.length();j++){
            if(j+2>str.length()){r=str.length();break;}
            else if((str.substring(j+1,j+2).matches("[0-9]"))==false){r=j+1;break;}
        }
      whole[i]=str.substring(l,r);
      for(int o=l;o<r;o++){
            light[o]=true;
        }}}}
   loop:for(int i=0;i<str.length();i++){
        if(str.substring(i,i+1).matches("[0-9]")==true&&light[i]==false){
        for(int j=i;j<str.length();j++){
           if(j==str.length()-1){whole[i]=String.valueOf(Double.valueOf(str.substring(i,j+1)));break loop;}
           else if((str.substring(j+1,j+2).matches("[0-9]"))==false){
           whole[i]=String.valueOf(Double.valueOf(str.substring(i,j+1)));i=j+1;break;}}}}
      whole=cleanBlank(whole);
      whole=combine(whole);
      whole=deletebrackets(whole);
      whole=calculate3(whole);
      whole=calculate1(whole);
      whole=calculate2(whole);
      return Double.valueOf(whole[0]);
    }
    public static void main(String args[]) throws Exception{
        Scanner input=new Scanner(System.in);
        while(input.hasNextLine()){
            double result=parse(input.nextLine());
            System.out.println(String.valueOf(Math.round(result)));
        }
    }
}