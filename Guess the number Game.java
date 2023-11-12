package suyash;
import java.util.Scanner;
import java.util.Random;
public class Game {
    public  int a;
    public  int b;
    public  int s;
    public  int e;

    public  int n;

   public void R()
   {
       //Create random function for generate number
       Random ge=new Random();
       int a= ge.nextInt(s,e);
       this.a=a;
   }
    public void B()
   {
       //Scanner for Input number;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter your number");
       int b=sc.nextInt();
       this.b=b;
   }

   public void C()
   {
       //Scanner for No of choices
       Scanner ne=new Scanner(System.in);
       System.out.println("Welcome");
       System.out.println("Enter no. of chances you want to give: ");
       int n= ne.nextInt();   //Take Input Chances no from user
       this.n=n;
   }
   public void S()
    {
        //Scanner for Staring value
        Scanner start=new Scanner(System.in);
        System.out.println("Enter your Start point value(From where you want to start)");
        int s=start.nextInt();
        this.s=s;
    }

    public void E()
    {
        //Scanner for Ending value
        Scanner end=new Scanner(System.in);
        System.out.println("Enter your End point value(To where you want to stop)");
        int e=end.nextInt();
        this.e=e;
    }


   public static void main(String[] args) {

       Game obj=new Game();   //Create an object
       //call all required methods
       obj.C();
       obj.S();
       obj.E();
       obj.R();
       System.out.println(obj.a);
       obj.B();
        for (int i=obj.n-1;i>=-1;i--)
           if (i>=0)
           {
               if (obj.b == obj.a) {
                   //Execute when user enter value equal to Computer value
                   System.out.println("Your Guess is correct,The no. is "+obj.a);
                   System.out.println("Your Score is "+(i+1)+" out of "+obj.n);
                   break;    //It break the for loop
               } else if (obj.b < obj.a) {
                   System.out.println("Your number is less");
                   System.out.println("You have only "+i+" Chances left");
                   obj.B();
               } else {
                   System.out.println("Your number is Greator");
                   System.out.println("You have only "+i+" Chances left");
                   obj.B();
               }
           }
            else
               {
               System.out.println();
               System.out.println("You lose the Game");
               System.out.println("The correct no. is "+obj.a);
           }
    }

}
