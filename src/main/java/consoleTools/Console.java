package consoleTools;

import cryptoAlgorithms.Caesar;

import java.util.Scanner;

public class Console {


    private final Scanner console = new Scanner(System.in);
    private final Caesar caesar = new Caesar();

    enum consoleCommand {
        EXIT, ENCRYPT, DECRYPT;

        public static consoleCommand fromOridnal(int n){
            for(consoleCommand cmd : values()){
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
            } catch (NumberFormatException e) {
                System.out.println("Please type one number which matches with command number");
                continue;
            }

            try{
                consoleCommand.fromOridnal(command);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Please provide absolute filepath to the input file");
            String inputFile = console.nextLine();
            System.out.println("Please provide absolute filepath to the output file");
            String outputFile = console.nextLine();

            switch (consoleCommand.fromOridnal(command)) {
                case EXIT:
                    exit();
                    return;
                case ENCRYPT:
                    caesar.encrypt(inputFile, outputFile);
                    break;
                case DECRYPT:
                    caesar.decrypt(inputFile, outputFile);
                    break;
            }

        } while ((command != 0));
    }


    private void exit() {
        console.close();
        System.out.println("Session is closed");
        System.exit(0);
    }

    private void printCommandsOptions(){
        System.out.println("Type 0 and press Enter to exit");
        System.out.println("Type 1 and press Enter to encrypt file via Caesar Algorithm");
        System.out.println("Type 2 and press Enter to decrypt file via Caesar Algorithm");
    }

}