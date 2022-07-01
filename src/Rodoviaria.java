import java.util.Scanner;

public class Rodoviaria {
    public static void main(String[] args) {
        Logo();
        Sleep();
        ClearConsole();
        Menu();

    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);

        int choice = 10;

        do {

            Interface();

            try {

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Reserve();
                        break;
                    case 2:
                        Cancel();
                        break;
                    case 3:
                        Sell();
                        break;
                    case 4:
                        Display();
                        break;
                }

            } catch (Exception e) {
                ClearConsole();
                System.out.println("Informe apenas o número da opção!");
                scanner.next();
                Sleep();
            }

            ClearConsole();

        } while (choice != 0);
        scanner.close();
    }

    public static void ClearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Logo() {
        ClearConsole();

        String red = "\u001B[35m";
        String green = "\u001B[32m";
        String reset = "\u001B[0m";

        System.out.print(red +
                "     ██╗ █████╗ ██╗   ██╗ █████╗ ██╗      ██████╗  ██████╗ \n" +
                "     ██║██╔══██╗██║   ██║██╔══██╗██║     ██╔═══██╗██╔════╝ \n" +
                "     ██║███████║██║   ██║███████║██║     ██║   ██║██║  ███╗\n" +
                "██   ██║██╔══██║╚██╗ ██╔╝██╔══██║██║     ██║   ██║██║   ██║\n" +
                "╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║███████╗╚██████╔╝╚██████╔╝\n" +
                " ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝╚══════╝ ╚═════╝  ╚═════╝ ");

        System.out.print(green + "\n" +
                "    .-------------------------------------------------------------.\n" +
                "   '------..-------------..----------..----------..----------..--.|\n" +
                "   |       ||            ||          ||          ||          ||  ||\n" +
                "   |        ||           ||          ||          ||          ||  ||\n" +
                "   |    ..   ||  _    _  ||    _   _ || _    _   ||    _    _||  ||\n" +
                "   |    ||   || //   //  ||   //  // ||//   //   ||   //   //|| /||\n" +
                "   | _.------''----------''----------''----------''----------''--'|\n" +
                "   |)|      |       |       |       |    |         |      ||==|   |\n" +
                "   | |      |  _-_  |       |       |    |  .-.    |      ||==|  C|\n" +
                "   | |  __  |.'.-.' |   _   |   _   |    |.'.-.'.  |  __  |'__  =='\n" +
                "   '---------'|( )|'----------------------'|( )|'----------''-----'\n" +
                "               '-'                          '-''\n" + reset);

        System.out.println(String.format("%06d", 1));
    }

    public static void Sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
    }

    public static void Interface() {

        String cyan = "\u001B[36m";
        String reset = "\u001B[0m";

        System.out.print(cyan +
                "--------------------------------------------------------------------------\n" +
                "░▀█░░░░░░░░░░█▀▄░█▀▀░█▀▀░█▀▀░█▀▄░█░█░█▀█░█▀▄░░░█▀█░█▀▀░█▀▀░█▀▀░█▀█░▀█▀░█▀█\n" +
                "░░█░░░░▄▄▄░░░█▀▄░█▀▀░▀▀█░█▀▀░█▀▄░▀▄▀░█▀█░█▀▄░░░█▀█░▀▀█░▀▀█░█▀▀░█░█░░█░░█░█\n" +
                "░▀▀▀░░░░░░░░░▀░▀░▀▀▀░▀▀▀░▀▀▀░▀░▀░░▀░░▀░▀░▀░▀░░░▀░▀░▀▀▀░▀▀▀░▀▀▀░▀░▀░░▀░░▀▀▀\n" +
                "░▀▀▄░░░░░░░░░█▀▀░█▀█░█▀█░█▀▀░█▀▀░█░░░█▀█░█▀▄░░░█▀▄░█▀▀░█▀▀░█▀▀░█▀▄░█░█░█▀█\n" +
                "░▄▀░░░░▄▄▄░░░█░░░█▀█░█░█░█░░░█▀▀░█░░░█▀█░█▀▄░░░█▀▄░█▀▀░▀▀█░█▀▀░█▀▄░▀▄▀░█▀█\n" +
                "░▀▀▀░░░░░░░░░▀▀▀░▀░▀░▀░▀░▀▀▀░▀▀▀░▀▀▀░▀░▀░▀░▀░░░▀░▀░▀▀▀░▀▀▀░▀▀▀░▀░▀░░▀░░▀░▀\n" +
                "░▀▀█░░░░░░░░░█░█░█▀▀░█▀█░█▀▄░█▀▀░█▀▄░░░█▀█░█▀▀░█▀▀░█▀▀░█▀█░▀█▀░█▀█        \n" +
                "░░▀▄░░░▄▄▄░░░▀▄▀░█▀▀░█░█░█░█░█▀▀░█▀▄░░░█▀█░▀▀█░▀▀█░█▀▀░█░█░░█░░█░█        \n" +
                "░▀▀░░░░░░░░░░░▀░░▀▀▀░▀░▀░▀▀░░▀▀▀░▀░▀░░░▀░▀░▀▀▀░▀▀▀░▀▀▀░▀░▀░░▀░░▀▀▀        \n" +
                "░█░█░░░░░░░░░█▀▀░█░█░▀█▀░█▀▄░▀█▀░█▀▄░░░█▀█░█▀█░█░░░▀█▀░█▀▄░█▀█░█▀█░█▀█░█▀▀\n" +
                "░░▀█░░░▄▄▄░░░█▀▀░▄▀▄░░█░░█▀▄░░█░░█▀▄░░░█▀▀░█░█░█░░░░█░░█▀▄░█░█░█░█░█▀█░▀▀█\n" +
                "░░░▀░░░░░░░░░▀▀▀░▀░▀░▀▀▀░▀▀░░▀▀▀░▀░▀░░░▀░░░▀▀▀░▀▀▀░░▀░░▀░▀░▀▀▀░▀░▀░▀░▀░▀▀▀\n" +
                "░▄▀▄░░░░░░░░░█▀▀░█▀█░▀█▀░█▀▄                                              \n" +
                "░█/█░░░▄▄▄░░░▀▀█░█▀█░░█░░█▀▄                                              \n" +
                "░░▀░░░░░░░░░░▀▀▀░▀░▀░▀▀▀░▀░▀                                              \n" +
                "--------------------------------------------------------------------------\n" + "->" + reset);
    }

    public static void Reserve() {
        ClearConsole();
        System.out.println("Ainda não implementado!");
        Sleep();
    }

    public static void Cancel() {
        ClearConsole();
        System.out.println("Ainda não implementado!");
        Sleep();
    }

    public static void Sell() {
        ClearConsole();
        System.out.println("Ainda não implementado!");
        Sleep();
    }

    public static void Display() {
        ClearConsole();
        System.out.println("Ainda não implementado!");
        Sleep();
    }
}