package utilities;

public class StringMethods {
    private static int n = 15;

    // function to generate a random string of length n
    private static String getAlphaNumericString() {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public static String randomEmail(){
        String alphaNumeric = getAlphaNumericString();
        String email = alphaNumeric + "@test.com";
        return email;
    }

    public static String getRandomString(){
        return getAlphaNumericString();
    }
}
