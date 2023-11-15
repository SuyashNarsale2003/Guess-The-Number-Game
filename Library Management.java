package suyash;
import java.util.Scanner;
public class LibraryManagement
{
    int n;
    String[] Available_Books;
    String[] issue_Books;

    public void LibrarySize()        //Use for set size of library
    {
        System.out.println("How many Maximum no. of books can " +
                "be store in your library");
        Scanner sc=new Scanner(System.in);
        this.n= sc.nextInt();
    }
    public void intialListofAvailableBooks()
    {
        String[] Available_Books = new String[n];
        for (int p=0;p<n;p++)
        {
            Available_Books[p]="(Available Space for new Book)";
        }
        this.Available_Books=Available_Books;
    }

    public void AddBooks()   //use to add multiple books at a time at starting
    {
        Scanner FirstAdd=new Scanner(System.in);
        System.out.println("Enter how many books are now" +
                " available to add in library");
        int p=FirstAdd.nextInt();
        if(p<=n)
        {
            for (int j = 0; j < p; j++) {
                Scanner add = new Scanner(System.in);
                System.out.format("Enter Your %d number book:- ", (j + 1));
                System.out.println();
                String D = add.nextLine();
                Available_Books[j] = D;
            }
        }
        else
        {
            System.out.println("Not enough space your library");
            System.out.println("You have only "+n+" no. of book places " +
                    "are available");
            AddBooks();
        }
        System.out.println("Your Books added successfully in your Library");
    }

    public void AddBooksAtSpecificLocation()  //add book at available spaces after library setup
    {
        ShowAvailableBooks();
        Scanner AddBookNo=new Scanner(System.in);
        Scanner AddBookName=new Scanner(System.in);
        System.out.println("Enter number where you want to Add book");
        int AvailableNoForAdd=AddBookNo.nextInt();
        System.out.println("Enter Name of Book which you want to add");
        int K=AvailableNoForAdd-1;
        Available_Books[K]=AddBookName.nextLine();
        System.out.println("Book Added successfully");
    }

    public void RemoveBooksFromSpecificLocation()  //remove book after library setup
    {
        ShowAvailableBooks();
        Scanner RemoveBookNo=new Scanner(System.in);
        Scanner RemoveBookName=new Scanner(System.in);
        System.out.println("Enter number where you want to Remove book");
        int AvailableNoForRemove=RemoveBookNo.nextInt();
        Available_Books[AvailableNoForRemove-1]=RemoveBookName.nextLine();
        Available_Books[AvailableNoForRemove-1]="(Available Space for new Book)";
        System.out.println("Book Removed successfully");
    }

    public void ShowAvailableBooks()   //It show all books in library
    {
        System.out.println("Available Books in library");
        int k = 1;
        for (String i : Available_Books) {
            System.out.println((k) + "." + i);
            k++;
        }
    }

    public void intialListofIssueBooks()
    {
        String[] issue_Books = new String[n];
        for (int o=0;o<n;o++)
        {
            issue_Books[o]="(Available Space for Book)";
        }
        this.issue_Books = issue_Books;
    }
    public void RemoveIssueBooksFromSpecificLocation()  //Use to remove book from Issued list
    {
        ShowAllIssuedBooks();
        Scanner RemoveIssueBookNo=new Scanner(System.in);
        Scanner RemoveIssueBookName=new Scanner(System.in);
        System.out.println("Enter no. of book which you want to Remove");
        int AvailableNoForRemoveIssueBook=RemoveIssueBookNo.nextInt();
        issue_Books[AvailableNoForRemoveIssueBook-1]=RemoveIssueBookName.nextLine();
        issue_Books[AvailableNoForRemoveIssueBook-1]="(Available Space for Book)";
        System.out.println("Book Removed successfully");
        System.out.println("Now Issued Books list is as below:");
        ShowAllIssuedBooks();
    }
    public void ShowAllIssuedBooks()   //It show all issue books
    {
        System.out.println("Issued Books in library:-");
        int l = 1;
        for (String m : issue_Books) {
            System.out.println((l) + "."+m);
            l++;
        }
    }

    public void TakeBookFromLibrary()   //use for issue a book
    {
        ShowAvailableBooks();
        System.out.println();
        System.out.println("Select no of Book which you want to Issued");
        Scanner TakeBook=new Scanner(System.in);
        int T=TakeBook.nextInt();
        ShowAllIssuedBooks();
        System.out.println();
        System.out.println("Select Available Space where you want to store your Issued" +
                " Book:-");
        Scanner FixBook=new Scanner(System.in);
        int I=FixBook.nextInt();
        int S=T-1;
        int R=I-1;
        String s=Available_Books[S];
        issue_Books[R]=s;
        System.out.println("Your Book Issued Successfully ");
        Available_Books[S]="(Available Space for book)";
    }
    public void ReturnBookToLibrary()   //Use for return the book
    {
        ShowAllIssuedBooks();
        System.out.println();
        System.out.println("Select no of Book which you want to return");
        Scanner FixBook=new Scanner(System.in);
        int I=FixBook.nextInt();
        ShowAvailableBooks();
        System.out.println();
        System.out.println("Select Available Space where you want to store your Book:-");
        Scanner returnBook=new Scanner(System.in);
        int T=returnBook.nextInt();
        int S=T-1;
        int R=I-1;
        String r=issue_Books[(R)];
        Available_Books[S]=r;
        issue_Books[(R)]="(Available Space for book)";
        System.out.println("Your book returned successfully");
    }
    public void Choice()
    {
        System.out.println();
        Scanner choose=new Scanner(System.in);
        System.out.print("1.Add Books in Library \n"  +
                "2.Remove Book From Library \n" +
                "3.Check Available Books in Library \n" +
                "4.Check Issued Books \n" +
                "5.Issue Book \n" +
                "6.Return Issued Book \n" +
                "7.Delete Issued Book");
        System.out.println();
        System.out.println("Choose which operation you want to perform " +
                "on your library");
        int C=choose.nextInt();
        if(C<=7 && C>0) {
            switch (C) {
                case 1:
                    AddBooksAtSpecificLocation();
                    break;
                case 2:
                    RemoveBooksFromSpecificLocation();
                    break;
                case 3:
                    ShowAvailableBooks();
                    break;
                case 4:
                    ShowAllIssuedBooks();
                    break;
                case 5:
                    TakeBookFromLibrary();
                    break;
                case 6:
                    ReturnBookToLibrary();
                    break;
                case 7:
                    RemoveIssueBooksFromSpecificLocation();
                    break;
            }
        }
        else
        {
            System.out.println("Please choose between option 1 to 7 only");

        }
        Choice();
    }


    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("           *   Welcome   *");
        System.out.println("-* First we need to setup your Library *-");
        System.out.println();
        LibraryManagement user=new LibraryManagement();
        user.LibrarySize();
        user.intialListofAvailableBooks();
        user.AddBooks();
        user.intialListofIssueBooks();
        System.out.println("Your Library Setup Completed");
        user.Choice();
    }
}
