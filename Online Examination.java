import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class OnlineExam {

    static String username = "student";
    static String password = "1234";
    static int score = 0;
    static boolean timeUp = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LOGIN
        System.out.println("===== Online Examination System =====");
        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Successful!\n");
            menu(sc);
        } else {
            System.out.println("Invalid Login!");
        }
    }

    public static void menu(Scanner sc) {

        int choice;

        do {
            System.out.println("\n1. Update Profile/Password");
            System.out.println("2. Start Exam");
            System.out.println("3. Logout");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    updateProfile(sc);
                    break;

                case 2:
                    startExam(sc);
                    break;

                case 3:
                    System.out.println("Logged Out Successfully!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 3);
    }

    public static void updateProfile(Scanner sc) {

        System.out.print("Enter New Username: ");
        username = sc.nextLine();

        System.out.print("Enter New Password: ");
        password = sc.nextLine();

        System.out.println("Profile Updated Successfully!");
    }

    public static void startExam(Scanner sc) {

        System.out.println("\nExam Started! You have 30 seconds.");

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;
                System.out.println("\nTime is up! Exam auto submitted.");
                System.out.println("Your Score: " + score);
                System.exit(0);
            }
        }, 30000);

        // Question 1
        System.out.println("\n1. Java is a?");
        System.out.println("a) Programming Language");
        System.out.println("b) Operating System");
        System.out.println("c) Database");
        System.out.println("d) Browser");

        String ans1 = sc.nextLine();
        if (ans1.equalsIgnoreCase("a")) score++;

        // Question 2
        System.out.println("\n2. Which keyword is used to create class?");
        System.out.println("a) define");
        System.out.println("b) class");
        System.out.println("c) create");
        System.out.println("d) new");

        String ans2 = sc.nextLine();
        if (ans2.equalsIgnoreCase("b")) score++;

        // Question 3
        System.out.println("\n3. Which method is entry point of Java?");
        System.out.println("a) start()");
        System.out.println("b) run()");
        System.out.println("c) main()");
        System.out.println("d) init()");

        String ans3 = sc.nextLine();
        if (ans3.equalsIgnoreCase("c")) score++;

        timer.cancel();

        System.out.println("\nExam Submitted Successfully!");
        System.out.println("Your Score: " + score + "/3");
    }
}