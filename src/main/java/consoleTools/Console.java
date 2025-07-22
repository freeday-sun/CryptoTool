package consoleTools;

import cryptoAlgorithms.caesar.Caesar;

import java.util.Scanner;

public class Console {


    private final Scanner console = new Scanner(System.in);
    private final Caesar caesar = new Caesar();

    enum consoleCommand {
        EXIT, ENCRYPT, DECRYPT;

        public static consoleCommand fromOridnal(int n) {
            for (consoleCommand cmd : values()) {
                if (cmd.ordinal() == n) return cmd;
            }
            throw new IllegalArgumentException("Command with number: " + n + " doesn't exist!");
        }
    }

    public void run() {
        int command = -1;
        do {
            printCommandsOptions();

            try {
                command = Integer.parseInt(console.nextLine());
                if(command == 0) break;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Command is not integer! Please provide a number which matches with command number!");
                continue;
            }

            try {
                consoleCommand.fromOridnal(command);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Please provide absolute filepath to the input file");
            String inputFile = console.nextLine();
            System.out.println("Please provide absolute filepath to the output file");
            String outputFile = console.nextLine();
            System.out.println("Please provide key for encryption");
            int key = 0;
            try {
                key = Integer.parseInt(console.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Key is not integer!");
                continue;
            }

            switch (consoleCommand.fromOridnal(command)) {
                case EXIT:
                    exit();
                    return;
                case ENCRYPT:
                    caesar.encrypt(inputFile, outputFile, key);
                    break;
                case DECRYPT:
                    caesar.decrypt(inputFile, outputFile, key);
                    break;
            }

        }while (command != 0);
    }


    private void exit() {
        console.close();
        System.out.println("Session is closed");
        System.exit(0);
    }

    private void printCommandsOptions() {
        System.out.println();
        System.out.println("Type 0 and press Enter to exit");
        System.out.println("Type 1 and press Enter to encrypt file via Caesar Algorithm");
        System.out.println("Type 2 and press Enter to decrypt file via Caesar Algorithm");
    }

}