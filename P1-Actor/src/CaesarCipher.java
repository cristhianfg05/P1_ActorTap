public class CaesarCipher {

    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    /**
     * Encrypts the message shifting the keys the times the variable
     * shiftKey has in it
     *
     * @param message
     * @param shiftKey
     * @return
     */
    public static String encrypt(String message, int shiftKey) {
        //Message in lowercase
        message = message.toLowerCase();

        //We create where the encrypted text will be
        String cipherText = "";

        //We go through every character in the string message
        for (char c: message.toCharArray()) {
            //If the character is a whitespace we add it to the encrypted message and move to the next character
            if(c == ' '){
                cipherText += ' ';
                continue;
            }
            //We calculate the position in the alphabet of the character
            int charPosition = alphabet.indexOf(c);
            //We calculate the new value for the next character
            int keyVal = (shiftKey + charPosition) % 26;
            //We get the character that will override the original one
            char replaceVal = alphabet.charAt(keyVal);

            //We add it to the text
            cipherText += replaceVal;
        }
        return cipherText;
    }


    /**
     * Decrypts the message shifting the keys the times the variable
     * shiftKey has in it
     *
     * @param cipherText
     * @param shiftKey
     * @return
     */
    public static String decrypt(String cipherText, int shiftKey) {
        //Cypher text in lowercase
        cipherText = cipherText.toLowerCase();
        //We create the new message where the decrypted message will be
        String message = "";
        //We iterate over the text
        for (char c : cipherText.toCharArray()) {
            //If it has whitespaces we add them to the message and continue
            if(c == ' '){
                message += ' ';
                continue;
            }
            //We calculate the position in the alphabet of the character
            int charPosition = alphabet.indexOf(c);
            //We calculate the new value of the next character
            int keyVal = (charPosition - shiftKey) % 26;
            //If the keyVal is negative we just convert it to a positive int
            if (keyVal < 0) {
                keyVal = alphabet.length() + keyVal;
            }
            //We get the next character that will replace the one in the encrypted message
            char replaceVal = alphabet.charAt(keyVal);
            //Add it
            message += replaceVal;
        }
        return message;
    }
}
