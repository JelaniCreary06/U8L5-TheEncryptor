import java.util.Arrays;

public class Runner
{
    public static void main(String[] args)
    {

    // -----------------------------------
    //   ---- TEST PART B: encryptBlock ----
    //   -----------------------------------
    System.out.println( '?' - 0);
    Encryptor encryptor4 = new Encryptor(4, 5);
    System.out.println(encryptor4.superEncryptMessage("Hello."));
    System.out.println(encryptor4.superDecryptMessage("J0AAgAAAnAAAnAAAqAAA"));

    }
}