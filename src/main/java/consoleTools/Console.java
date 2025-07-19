package consoleTools;

import cryptoAlgorithms.Caesar;

import java.util.Scanner;

public class Console {


    private final Scanner console = new Scanner(System.in);
    private final Caesar caesar = new Caesar();

    public void run(){
        int command = -1;
        do{
            System.out.println("Type 0 and press Enter to exit");
            System.out.println("Type 1 and press Enter to encrypt file via Caesar Algorithm");
            System.out.println("Type 2 and press Enter to decrypt file via Caesar Algorithm");

            //Checking command
            try {
                command = Integer.parseInt(console.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please type one of the command");
            }

            String inputFile;
            String outputFile;
            switch (command){
                case 0:
                    exit();
                    break;
                case 1:
                    System.out.println("Please provide absolute filepath to the input file");
                    inputFile = console.nextLine();
                    System.out.println("Please provide absolute filepath to the output file");
                    outputFile = console.nextLine();
                    caesar.encrypt(inputFile, outputFile);
                    break;
                case 2:
                    System.out.println("Please provide absolute filepath to the input file");
                    inputFile = console.nextLine();
                    System.out.println("Please provide absolute filepath to the output file");
                    outputFile = console.nextLine();
                    caesar.decrypt(inputFile, outputFile);
                    break;
            }

        }while((command != 0));
        exit();
    }


    private void exit(){
        console.close();
        System.exit(0);
    }
}
