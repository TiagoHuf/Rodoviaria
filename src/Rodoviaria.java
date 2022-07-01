import java.util.Scanner;

public class Rodoviaria {
    public static void main(String[] args) {
        String[] busA = new String[44];
        String[] busB = new String[44];
        FillVetor(busA);
        FillVetor(busB);
        
        Logo();
        
        
        Menu(busA, busB);

    }

    public static void Menu(String[] busA, String[] busB) {
        Scanner scanner = new Scanner(System.in);

        int choiceMenu = 10;

        do {
            ClearConsole();
            Interface();

            try {
                choiceMenu = scanner.nextInt();

                switch (choiceMenu) {
                    case 1:
                        Reserve(busA, busB);
                        ReservatioSuccess();
                        break;
                    case 2:
                        Sell(busA, busB);
                        break;
                    case 3:
                        Cancel(busA, busB);
                        break;
                    case 4:
                        int busChoice = Choice();
                        if(busChoice == 1)
                            Display(busA, true);
                        else if(busChoice == 2)
                            Display(busB, true);
                        else
                            Error(1);
                        break;
                }

            } catch (Exception e) {
                ClearConsole();
                System.out.println("Informe apenas o número da opção!");
                scanner.next();
                Sleep();
            }

            ClearConsole();

        } while (choiceMenu != 0);
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

        String logo = (red +
                "     ██╗ █████╗ ██╗   ██╗ █████╗ ██╗      ██████╗  ██████╗ \n" +
                "     ██║██╔══██╗██║   ██║██╔══██╗██║     ██╔═══██╗██╔════╝ \n" +
                "     ██║███████║██║   ██║███████║██║     ██║   ██║██║  ███╗\n" +
                "██   ██║██╔══██║╚██╗ ██╔╝██╔══██║██║     ██║   ██║██║   ██║\n" +
                "╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║███████╗╚██████╔╝╚██████╔╝\n" +
                " ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝╚══════╝ ╚═════╝  ╚═════╝ \n" + reset);

            ClearConsole();
            System.out.println(logo);

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
            Sleep();
            ClearConsole();
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
        String green = "\u001B[32m";

        ClearConsole();
        String menu = (cyan +
                " _             __                                         _                      _                                             \n" +
                "/ |           /__\\ ___  ___  ___ _ ____   ____ _ _ __    /_\\  ___ ___  ___ _ __ | |_ ___                                       \n" +
                "| |  _____   / \\/// _ \\/ __|/ _ \\ '__\\ \\ / / _` | '__|  //_\\\\/ __/ __|/ _ \\ '_ \\| __/ _ \\                                      \n" +
                "| | |_____| / _  \\  __/\\__ \\  __/ |   \\ V / (_| | |    /  _  \\__ \\__ \\  __/ | | | || (_) |                                     \n" +
                "|_|         \\/ \\_/\\___||___/\\___|_|    \\_/ \\__,_|_|    \\_/ \\_/___/___/\\___|_| |_|\\__\\___/                                      \n" +
                "                                                                                                                               \n" +
                " ____                                _               _                      _                                                  \n" +
                "|___ \\          /\\   /\\___ _ __   __| | ___ _ __    /_\\  ___ ___  ___ _ __ | |_ ___                                            \n" +
                "  __) |  _____  \\ \\ / / _ \\ '_ \\ / _` |/ _ \\ '__|  //_\\\\/ __/ __|/ _ \\ '_ \\| __/ _ \\                                           \n" +
                " / __/  |_____|  \\ V /  __/ | | | (_| |  __/ |    /  _  \\__ \\__ \\  __/ | | | || (_) |                                          \n" +
                "|_____|           \\_/ \\___|_| |_|\\__,_|\\___|_|    \\_/ \\_/___/___/\\___|_| |_|\\__\\___/                                           \n" +
                "                                                                                                                               \n" +
                " _____             ___                     _                __                                   __                    _       \n" +
                "|___ /            / __\\__ _ _ __   ___ ___| | __ _ _ __    /__\\ ___  ___  ___ _ ____   ____ _   / /\\   /\\___ _ __   __| | __ _ \n" +
                "  |_ \\   _____   / /  / _` | '_ \\ / __/ _ \\ |/ _` | '__|  / \\/// _ \\/ __|/ _ \\ '__\\ \\ / / _` | / /\\ \\ / / _ \\ '_ \\ / _` |/ _` |\n" +
                " ___) | |_____| / /__| (_| | | | | (_|  __/ | (_| | |    / _  \\  __/\\__ \\  __/ |   \\ V / (_| |/ /  \\ V /  __/ | | | (_| | (_| |\n" +
                "|____/          \\____/\\__,_|_| |_|\\___\\___|_|\\__,_|_|    \\/ \\_/\\___||___/\\___|_|    \\_/ \\__,_/_/    \\_/ \\___|_| |_|\\__,_|\\__,_|\n" +
                " _  _               __      _ _     _          ___      _ _                                                                    \n" +
                "| || |             /__\\_  _(_) |__ (_)_ __    / _ \\___ | | |_ _ __ ___  _ __   __ _ ___                                        \n" +
                "| || |_   _____   /_\\ \\ \\/ / | '_ \\| | '__|  / /_)/ _ \\| | __| '__/ _ \\| '_ \\ / _` / __|                                       \n" +
                "|__   _| |_____| //__  >  <| | |_) | | |    / ___/ (_) | | |_| | | (_) | | | | (_| \\__ \\                                       \n" +
                "   |_|           \\__/ /_/\\_\\_|_.__/|_|_|    \\/    \\___/|_|\\__|_|  \\___/|_| |_|\\__,_|___/                                       \n" +
                "                                                                                                                               \n" +
                "  ___            __       _                                                                                                    \n" +
                " / _ \\          / _\\ __ _(_)_ __                                                                                               \n" +
                "| | | |  _____  \\ \\ / _` | | '__|                                                                                              \n" +
                "| |_| | |_____| _\\ \\ (_| | | |                                                                                                 \n" +
                " \\___/          \\__/\\__,_|_|_|                                                                                                 \n");

                String seta = green + "->" + reset;

                System.out.println(menu);
                System.out.println(seta);
            }

    public static void Reserve(String[] busA, String[] busB) {
        do{
            ClearConsole();
            ReserveDisplay();
            int bus = 0;

            try {
                bus = Choice();
            }catch(Exception e){
                Error(1);
                return;
            }

            if(bus == 1){
                SeatReserve(busA);
                return;
            }else if(bus == 2){
                SeatReserve(busB);
                return;
            }else{
                Error(1);
            }
        }while(true);
    }

    public static void Cancel(String[] busA, String[] busB) {
        ClearConsole();
        do{
            ClearConsole();
            ReserveDisplay();
            int bus = 0;

            try {
                bus = Choice();
            }catch(Exception e){
                Error(1);
                return;
            }

            if(bus == 1){
                ReserveCancel(busA);
                return;
            }else if(bus == 2){
                ReserveCancel(busB);
                return;
            }else{
                Error(1);
            }
        }while(true);
    }

    public static void Sell(String[] busA, String[] busB) {
        ClearConsole();
        do{
            ClearConsole();
            ReserveDisplay();
            int bus = 0;

            try {
                bus = Choice();
            }catch(Exception e){
                Error(1);
                return;
            }

            if(bus == 1){
                SeatSell(busA);
                return;
            }else if(bus == 2){
                SeatSell(busB);
                return;
            }else{
                Error(1);
            }
        }while(true);
    }

    public static void Display(String[] bus, Boolean consulta) {
        ClearConsole();
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        String yellow = "\u001B[33m";
        String red = "\u001B[31m";
        String blue = "\u001B[34m";

        if(consulta)
            SeatDisplay();
        else
            SeatSelectorDisplay();

        System.out.print(yellow + "\t\t");

        for(int i=0;i<44;i++) {

            if(bus[i] == "AV")
                System.out.print("[" + blue);
            else if(bus[i] == "AR")
                System.out.print("[" + red);
            else
                System.out.print("[" + green);

            System.out.print(bus[i] + yellow +"]");
            if((i+1) % 2 == 0) {
                System.out.print("  ");
            }
            if( (i+1) % 4 == 0) {
                System.out.print("\n\t\t");
            }
        }

        System.out.println(reset + "\n");

        if(consulta){
            System.out.println(green + "Pressione ENTER para continuar..." + reset);
            try{
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                ClearConsole();
                return;
            }catch(Exception e){
                ClearConsole();
                return;
            }
        }else{
            System.out.print(green + "\n\n->" + reset);
        }
    }

    public static void ReserveDisplay(){
        System.out.println("Reserva");
    }

    public static void SeatReserve(String[] bus){
        int choice = 0;
        choice = SeatChoice(bus);
        bus[choice] = "AR";
    }

    public static void SeatSell(String[] bus){
        int choice = 0;
        choice = SeatChoice(bus);
        bus[choice] = "AV";
    }

    public static void ReserveCancel(String[] bus){
        int choice = 0;
        choice = SeatChoice(bus);
        bus[choice] = (String.format("%02d", choice));
    }

    public static int Choice(){
        BusSelector();
        Scanner scanner = new Scanner(System.in);

        try{
            int choice = 0;
            choice = scanner.nextInt();

            return choice;
        }catch(Exception e){
            Error(1);
            return -1;
        }
    }

    public static int SeatChoice(String [] bus){
        Display(bus, false);
        Scanner scanner = new Scanner(System.in);

        try{
            int choice = 0;
            choice = scanner.nextInt();

            return choice;
        }catch(Exception e){
            Error(1);
            return -1;
        }
    }

    public static void Error(int erro){
        String red = "\u001B[35m";
        String reset = "\u001B[0m";

        switch(erro){
            case 1 :
                ClearConsole();
                System.out.println(red + "Escolha entre 1 e 2!" + reset);
                Sleep();
                ClearConsole();
        }
    }

    public static void FillVetor(String[] bus){
        for (int i = 0; i < bus.length; i++) {
            bus[i] = (String.format("%02d", i));
        }
    }

    public static void BusSelector(){
        ClearConsole();
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        String yellow = "\u001B[33m";
        String cyan = "\u001B[36m";

        System.out.println(cyan +
            " _____               _ _                                 _ _                \n" +
            "| ____|___  ___ ___ | | |__   __ _    ___     ___  _ __ (_) |__  _   _ ___ \n" +
            "|  _| / __|/ __/ _ \\| | '_ \\ / _` |  / _ \\   / _ \\| '_ \\| | '_ \\| | | / __|\n" +
            "| |___\\__ \\ (_| (_) | | | | | (_| | | (_) | | (_) | | | | | |_) | |_| \\__ \\\n" +
            "|_____|___/\\___\\___/|_|_| |_|\\__,_|  \\___/   \\___/|_| |_|_|_.__/ \\__,_|___/\n"
        );

        System.out.println(yellow +
            "                                     __ \n" +
            "    _       .-----------------------'  |\n" +
            "   / |     /| _ .---. .---. .---. .---.|\n" +
            "   | |     |j||||___| |___| |___| |___||\n" +
            "   | |     |=|||===========1===========|\n" +
            "   |_|     [_|j||(O)\\__________|(O)\\___]\n"
        );
        System.out.print(
            "                                     __ \n" +
            " ____       .-----------------------'  |\n" +
            "|___ \\     /| _ .---. .---. .---. .---.|\n" +
            "  __) |    |j||||___| |___| |___| |___||\n" +
            " / __/     |=|||===========2===========|\n" +
            "|_____|    [_|j||(O)\\__________|(O)\\___]\n" + green + "\n\n->" + reset 
        );
    }

    public static void SeatSelectorDisplay(){
        String reset = "\u001B[0m";
        String cyan = "\u001B[36m";
        
        System.out.println(cyan +
            " _____               _ _                                              _         \n" +
            "| ____|___  ___ ___ | | |__   __ _    ___     __ _ ___ ___  ___ _ __ | |_ ___  \n" +
            "|  _| / __|/ __/ _ \\| | '_ \\ / _` |  / _ \\   / _` / __/ __|/ _ \\ '_ \\| __/ _ \\ \n" +
            "| |___\\__ \\ (_| (_) | | | | | (_| | | (_) | | (_| \\__ \\__ \\  __/ | | | || (_) |\n" +
            "|_____|___/\\___\\___/|_|_| |_|\\__,_|  \\___/   \\__,_|___/___/\\___|_| |_|\\__\\___/ \n\n\n" + reset 
        );
    }

    public static void SeatDisplay(){
        String reset = "\u001B[0m";
        String cyan = "\u001B[36m";

        System.out.println(cyan +
        "     _                       _            \n" +
        "    / \\   ___ ___  ___ _ __ | |_ ___  ___ \n" +
        "   / _ \\ / __/ __|/ _ \\ '_ \\| __/ _ \\/ __|\n" +
        "  / ___ \\\\__ \\__ \\  __/ | | | || (_) \\__ \\\n" +
        " /_/   \\_\\___/___/\\___|_| |_|\\__\\___/|___/\n" + reset 
        );
    }

    public static void ReservatioSuccess(){
        ClearConsole();
        String green = "\u001B[32m";
        String reset = "\u001B[0m";

        System.out.println(green +
            " ____                                   __      _                   _                                                                     _ \n" +
            "|  _ \\ ___  ___ _ ____   ____ _    ___ / _| ___| |_ _   _  __ _  __| | __ _    ___ ___  _ __ ___    ___ _   _  ___ ___  ___ ___ ___  ___ | |\n" +
            "| |_) / _ \\/ __| '__\\ \\ / / _` |  / _ \\ |_ / _ \\ __| | | |/ _` |/ _` |/ _` |  / __/ _ \\| '_ ` _ \\  / __| | | |/ __/ _ \\/ __/ __/ __|/ _ \\| |\n" +
            "|  _ <  __/\\__ \\ |   \\ V / (_| | |  __/  _|  __/ |_| |_| | (_| | (_| | (_| | | (_| (_) | | | | | | \\__ \\ |_| | (_|  __/\\__ \\__ \\__ \\ (_) |_|\n" +
            "|_| \\_\\___||___/_|    \\_/ \\__,_|  \\___|_|  \\___|\\__|\\__,_|\\__,_|\\__,_|\\__,_|  \\___\\___/|_| |_| |_| |___/\\__,_|\\___\\___||___/___/___/\\___/(_)\n" + reset
        );

        Sleep();
    }
}