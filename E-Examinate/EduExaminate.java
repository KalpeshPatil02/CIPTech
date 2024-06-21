package advjava103;

import java.util.HashMap;
import java.util.Scanner;

public class EduExaminate {
	HashMap<String, Integer> d = new HashMap<String, Integer>();
    Scanner input = new Scanner(System.in);

    public void login() {
        System.out.println("\n********** Welcome to EduExaminate - By AyushSarfare **********\n");
        System.out.println("1. Sign Up\n2. Login");
        System.out.println("\n Enter your choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
            	signUp();
                break;
            case 2:
                authenticate();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                login();
        }
    }

    public void authenticate() {
        System.out.println("Enter Username: ");
        String userName = input.next();
        System.out.println("Enter Password: ");
        int password = input.nextInt();
        if (d.containsKey(userName) && d.get(userName) == password) {
            System.out.println("Log-In Successful!");
            main();
        } else {
            System.out.println("Invalid Username or Password !! Try Signing Up !!");
            login();
        }
    }

    public void signUp() {
        System.out.println("Enter Username: ");
        String userName = input.next();
        if (d.containsKey(userName)) {
            System.out.println("User Already Exists ! Please try Logging in.");
            login();
        } else {
            System.out.println("Enter Password: ");
            int password = input.nextInt();
            d.put(userName, password);
            System.out.println("Sign Up Successful! Please Login to continue.");
            login();
        }
    }

    public void main() {
        System.out.println("\n1.Update Account\n2.Start test\n3.Logout");
        System.out.println("\n Enter your choice: ");
        int op = input.nextInt();
        switch (op) {
            case 1:
                update();
                main();
                break;
            case 2:
                solve();
                main();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public void update() {
        System.out.println("\n----- Update -----");
        System.out.println("Enter Username: ");
        String id = input.next();

        if (d.containsKey(id)) {
            System.out.println("Enter New Password: ");
            int newpd = input.nextInt();
            d.replace(id, newpd);
            System.out.println("Profile Update Success!");
        } else {
            System.out.println("User does not exist...");
            System.out.println("Profile Update Failed!");
        }
    }

    public void solve() {
        long start = System.currentTimeMillis();
        long terminate = start + 60 * 1000;
        int score = 0;
        int c = 0, w = 0;
        char ans;
        System.out.println("\n\n***** Starting The Test *****");
        System.out.println("You have 1 Minute to answer each question. Select the options wisely... ");
        System.out.println("Each question gives +2 marks for a correct answer and -1 mark for a wrong answer.");
        System.out.println("All the very best!!");

        while (System.currentTimeMillis() < terminate) {
            System.out.println("\nQ1. Which of the following below live on the heap in Java?");
            System.out.println("a.Class\nb.Instance Variable\nc.Object\nd.Method");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'c') {
                c += 1;
            } else
                w -= 1;

            System.out.println("\nQ2.Which of these interface handle sequences?");
            System.out.println("a.Comparator\nb.List\nc.Collection\nd.Set");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'b') {
                c += 1;
            } else
                w -= 1;

            System.out.println("\nQ3.What is TRUE about the finalize() method?");
            System.out.println(
                    "a.It may be called zero or one times.\nb.It may be called zero or more times.\nc.It will be called exactly once.\nd.It may be called one or more times.");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'a') {
                c += 1;
            } else
                w -= 1;

            System.out.println("\nQ4.Which of the following interface must contain a unique element?");
            System.out.println("a.Set\nb.Collection\nc.List\nd.Array");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'a') {
                c += 1;
            } else
                w -= 1;

            System.out.println("\nQ5.Which of the following does not compile?");
            System.out.println(
                    "a.int num = 999;\nb.int num = 9_9_9;\nc.int num = _9_99\nd.None of the above;they all compile");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'c') {
                c += 1;
            } else
                w -= 1;
            break;
        }

        System.out.println("\nTest Completed!");
        score = ((c * 2) + w);
        System.out.println("Number of correct answers: " + c);
        System.out.println("Congratulations!! Your score is " + score + " Out of 10.\n");
    }

    public static void main(String args[]) {
    	EduExaminate e = new EduExaminate();
        e.login();
    }
}
