import java.util.ArrayList;
import java.util.Scanner;

class Book{
    int Id;
    String Title;
    String Author;
    int Quantity;

//    constructor for Book class
    public Book(int id, String title, String author, int quantity) {
        Id = id;
        Title = title;
        Author = author;
        Quantity = quantity;
    }

//    getter and setters
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }

    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

//    display the book details
    public void getDetails(){
        System.out.println("Id       : "+Id+"\n"+"Title    : "+Title+"\n"+"Author   : "+Author+"\n"+"Quantity : "+Quantity);
    }
}
public class Exercise {
    static Scanner scanner=new Scanner(System.in);
    static ArrayList<Book> Books=new ArrayList<>();


//    method for adding books
    static void addBook(){
//        creating array list for ids
        ArrayList<Integer> idArray=new ArrayList<>();

        for(Book b:Books){
            idArray.add(b.getId());
        }
        System.out.print("How Many Books do you Want to add:");
        int bookCount=scanner.nextInt();

        for (int i = 0; i < bookCount; i++) {
            System.out.print("Enter book id:");
            int id = scanner.nextInt();
            if(idArray.contains(id)){
                System.out.println("Duplicate id, Try-Again");
                break;
            }

            scanner.nextLine();

            System.out.print("Enter book title:");
            String title = scanner.nextLine();

            System.out.print("Enter book author:");
            String author = scanner.nextLine();

            System.out.print("Enter book quantity:");
            int quantity = scanner.nextInt();

            System.out.println("**** book added ****\n");

            Book input = new Book(id, title, author, quantity);
            Books.add(input);

        }
    }
//  display book method
    static void displayBooks(){
        if(!Books.isEmpty()){
            System.out.println("***** Available books *****");

            for(Book b:Books){
                b.getDetails();
                System.out.println();
            }
        }
        else{
            System.out.println("Sorry! there are no available Books");
        }

    }

//  method for searching book
    static void SearchBook(){
        if(!Books.isEmpty()){
            ArrayList<String> titleArray=new ArrayList<>();

            for(Book b:Books){
                titleArray.add(b.getTitle());
            }
            System.out.print("Enter the book you want to search:");
            String s=scanner.next();
            if(titleArray.contains(s)){
                for(Book b:Books){
                    if(b.getTitle().equals(s)){
                        b.getDetails();
                    }
                }
            }
            else{
                System.out.println("Not found");
            }
        }else{
            System.out.println("Sorry! there are no available Books");
        }

    }

//    update the book method
    static void updateBook() {
        if (!Books.isEmpty()) {
            System.out.print("Which book do you want to update(use id):");
            int updatedBook = scanner.nextInt();
            for (Book b : Books) {
                if (b.getId() == updatedBook) {
                    System.out.print("Which do you want to update:\n1.Id\n2.Title\n3.Author\n4.Quantity\n");
                    System.out.print("Enter your choice:");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Enter the new Id:");
                            String newId = scanner.next();
                            b.setTitle(newId);
                            System.out.println("Id updated successfully\n");
                            break;
                        case 2:
                            System.out.print("Enter the new Title:");
                            String newTitle = scanner.next();
                            b.setTitle(newTitle);
                            System.out.println("Title updated successfully\n");
                            break;
                        case 3:
                            System.out.print("Enter the new Author name:");
                            String newAuthor = scanner.next();
                            b.setAuthor(newAuthor);
                            System.out.println("Author name updated successfully\n");
                            break;
                        case 4:
                            System.out.print("Enter the new Quantity:");
                            int newQuantity = scanner.nextInt();
                            b.setQuantity(newQuantity);
                            System.out.println("Quantity updated successfully\n");
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                }
            }
        }else{
            System.out.println("Sorry! there are no available Books");
        }
    }

//    method for deleting the book
    static void deleteBook(){
        if(!Books.isEmpty()) {
            ArrayList<Integer> idArray = new ArrayList<>();

            for (Book b : Books) {
                idArray.add(b.getId());
            }
            System.out.print("Enter the id to delete the book:");
            int deletedBook = scanner.nextInt();
            if (idArray.contains(deletedBook) && deletedBook > 0) {
                Books.remove(deletedBook - 1);
                System.out.println("***** Book deleted Successfully *****");
            } else
                System.out.println("Invalid Index");
        }else{
            System.out.println("Sorry! there are no available Books");
        }
    }


    public static void main(String[] args) {
        Book b1 = new Book(1, "Harry Potter", "J.K Rowling", 10);
        Book b2 = new Book(2, "Vekkai", "Poomani", 15);
        Book b3 = new Book(3, "Ramayanam", "Kambar", 12);
        Book b4 = new Book(4, "Mahabharatham", "Vyasar", 8);
        Book b5 = new Book(5, "Kolayuthir Kaalam", "Rajesh Kumar", 22);
//        Books.add(b1);
//        Books.add(b2);
//        Books.add(b3);
//        Books.add(b4);
//        Books.add(b5);

        System.out.println("********************");
        System.out.println("Java Library Program");
        System.out.println("********************");

        int finalChoice = 0;

        while(finalChoice<6){
            System.out.println("""
                -------------------
                1.Display Books
                2.Add Book
                3.Search Book
                4.Update Book
                5.Delete Book
                6.Quit
                """);
            System.out.print("Enter the choice:");
            finalChoice = scanner.nextInt();
            switch (finalChoice) {
                case 0:
                    System.out.println("Invalid Choice");break;
                case 1:
                    displayBooks();break;
                case 2:
                    addBook();break;
                case 3:
                    SearchBook();break;
                case 4:
                    updateBook();break;
                case 5:
                    deleteBook();break;
                default:
                    System.out.println("Bye!...");
            }
        }

        scanner.close();
    }
}
