import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DecryptCipher {

    public static void main(String[] args) throws FileNotFoundException {

        try {

            if (args.length == 0)
                // Print instructions to the console about the parameters
                System.out.println("You need to specify the parameters."
                        + "\nIn eclipse add to Run configurations -> arguments"
                        + "\nThere are two arguments separated with a space: \n"
                        + "\n1. the letters of the ciphertext in lowercase"
                        + "\n2. the corresponding letters of the plaintext in uppercase");
            else {
                // Read the cipherkey and plaintextkey from the input parameters in the args
                // String Array
                char[] cipherkey = args[0].toCharArray();
                char[] plaintextkey = args[1].toCharArray();
                String plainText = null;

                // Initialise paths to files. Uncomment/Comment the ciphertext file to be used
                // Note: To use the following paths, you need to create a folder named javafiles
                // on the C: drive
                // Then, add the ciphertext1.txt and ciphertext2.txt files from moodle to the
                // javafiles folder
                Path pathOfCipherText = Paths
                        .get("/Users/petercorcoran/VSCodium_Java_Workspace/Software_Design_4.2/src/ciphertext2.txt");
                // Path pathOfCipherText = Paths.get("c:", "javafiles", "ciphertext2.txt");
                Path pathOfPlainText = Paths
                        .get("/Users/petercorcoran/VSCodium_Java_Workspace/Software_Design_4.2/src/plaintext2.txt");

                // Print the file paths of both the Ciphertext file and the decrypted plaintest
                // file
                System.out.print("Ciphertext file path is: " + pathOfCipherText.toString() + "\n");
                System.out.print("Plaintext file path is: " + pathOfPlainText.toString() + "\n\n");

                // Read the ciphertext from the cipherText file
                String cipherText = readFromFile(pathOfCipherText.toFile());

                // Convert the cipherText with plaintext based on the keys input as arguments to
                // this java application. Note: You input them in the configurations parameters
                plainText = replacetext(cipherText, cipherkey[0], plaintextkey[0]);
                for (int i = 0; i < cipherkey.length; i++) {

                    plainText = replacetext(plainText, cipherkey[i], plaintextkey[i]);
                }

                // Print the resulting plaintext to screen
                // System.out.print("The following is the contents of the latest plaintext file
                // \n\n");
                System.out.print(plainText);
                writeToFile(pathOfPlainText, plainText);
            }

            // } catch (Exception e) {
            // e.printStackTrace();
            //
            // }
        } finally {
            System.out.println("Finished running program");

        }

    }

    // Replace ciphertext characters with plaintext characters
    public static String replacetext(String input, char fromchar, char tochar) {

        char[] text = input.toCharArray();

        String newString1 = input.replace(fromchar, tochar);

        return newString1;

    }

    // Read from file
    public static String readFromFile(File inputFile) {
        byte[] inBytes = new byte[1024];
        int size = 0;
        FileInputStream fileInputStream = null;
        String fileContent = "";
        try {
            fileInputStream = new FileInputStream(inputFile);
            size = fileInputStream.read(inBytes);

            // Convert from bytes to characters
            for (byte b : inBytes) {
                System.out.print((char) b);
                fileContent = fileContent + (char) b;
            }

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ensure that you have set up the javafiles folder in the C: drive \n"
                    + " and added the ciphertext1.txt and ciphertext2.txt files to the folder\n"
                    + "Alternatively, change the path location to that of where you have stored the files. \n");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(fileContent + "\n");

        return fileContent;
    }

    // Write to a file
    public static void writeToFile(Path outputPath, String text) {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputPath.toFile());
            fileOutputStream.write(text.getBytes("UTF-8"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out
                    .println("This error is will be fixed when you fix the input file path and your first decryption");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}