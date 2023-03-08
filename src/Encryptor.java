import java.util.Arrays;

public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        for (int i = 0, c = 0; i < letterBlock.length; i++) {
            for (int j = 0; j < letterBlock[i].length; j++) {
                if (c == str.length() &&  j < letterBlock[i].length) letterBlock[i][j] = "A";
                else {
                    letterBlock[i][j] = str.charAt(c)+"";
                    c++;
                }
            }
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String toReturn = "";

        for (int i = 0; i < letterBlock[0].length; i++) {
            for (int j = 0; j < letterBlock.length; j++) {
                toReturn += letterBlock[i][j];
            }
        }

        return toReturn;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        String toReturn = "";

        for (int i = 0, p = 0; i < message.length(); i += p) {
            if (message.length() < (numRows * numCols)) {
                fillBlock(message);
                return encryptBlock();
            } else {
                if (p + (numRows * numCols) < message.length()) p = message.length();
                fillBlock(message.substring(i, p));
                toReturn += encryptBlock();
                p += (numRows * numCols);
                letterBlock = new String[numRows][numCols];
            }
        }

        return toReturn;
    }

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        letterBlock = new String[numRows][numCols];
        String toReturn = "";
        for (int i = 0, c = 0; i < encryptedMessage.length(); i++) {
            for (int j = 0, k = 0; j < letterBlock[0].length; k++) {
                letterBlock[j][k] = encryptedMessage.charAt(i)+"";

                if (k == letterBlock.length - 1) {
                    k = 0; j++;
                }
            }

            for (int j = 0; j < letterBlock.length; j++) {
                for (int k = 0; k < letterBlock[i].length; k++) {
                    toReturn += letterBlock[j][k];
                }
            }

            if (encryptedMessage.substring(0, i).length() != toReturn.length()) letterBlock = new String[numRows][numCols];
        }

        StringBuilder str = new StringBuilder(toReturn);
        while (str.lastIndexOf("A") == str.length() - 1) {
            str.setCharAt(str.lastIndexOf("A"), '\0');
        }

        return str.toString();
    }
}