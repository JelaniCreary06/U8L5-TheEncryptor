import java.util.Arrays;

public class Runner
{
    public static void main(String[] args)
    {

    // -----------------------------------
    //   ---- TEST PART B: encryptBlock ----
    //   -----------------------------------
    System.out.println("\n---- TESTING PART B ----");
    Encryptor encryptor4 = new Encryptor(1000, 84);
    System.out.println(encryptor4.encryptMessage("Often the ease of detectability of an acrostic can depend on the intention of its creator. In some cases an author may desire an acrostic to have a better chance of being perceived by an observant reader, such as the acrostic contained in the Hypnerotomachia Poliphili (where the key capital letters are decorated with ornate embellishments). However, acrostics may also be used as a form of steganography, where the author seeks to conceal the message rather than proclaim it. This might be achieved by making the key letters uniform in appearance with the surrounding text, or by aligning the words in such a way that the relationship between the key letters is less obvious. These are referred to as null ciphers in steganography, using the first letter of each word to form a hidden message in an otherwise innocuous text.[5] Using letters to hide a message, as in acrostic ciphers, was popular during the Renaissance, and could employ various methods of enciphering, such as selecting other letters than initials based on a repeating pattern (equidistant letter sequences), or even concealing the message by starting at the end of the text and working backwards.[6]"));
    System.out.println(encryptor4.decryptMessage("IlyAA'yAAAm AAA sAAArlAAAeeAAAaeAAAlpAAA"));

    }

    public static void print2DArray(String[][] arr)
    {
        for (String[] row : arr)
        {
            for (String val : row)
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static boolean testArr(String[][] expected, String[][] actual)
    {
        if (expected.length != actual.length)
        {
            return false;
        }

        if (expected[0].length != actual[0].length)
        {
            return false;
        }

        for (int row = 0; row < expected.length; row++)
        {
            for (int col = 0; col < expected[0].length; col++)
            {
                String expElement = expected[row][col];
                String actElement = actual[row][col];
                if (!expElement.equals(actElement))
                {
                    return false;
                }
            }
        }
        return true;
    }
}