package data;

import exceptions.WrongSmallCodeFormatException;

import java.util.Random;

final public class SmallCode {

    private final String smallCode;

    public SmallCode(String smallCode) throws WrongSmallCodeFormatException {
        checkValidSmallCode(smallCode);
        this.smallCode = smallCode;
    }

    private void checkValidSmallCode(String smallCode) throws WrongSmallCodeFormatException {
        if (smallCode == null) throw new NullPointerException("Small Code cannot be null.");
        if (smallCode.length() != 3) throw new WrongSmallCodeFormatException("Small Code must be 3 characters long.");
        if (wrongSmallCodeFormat(smallCode)) throw new WrongSmallCodeFormatException("Incorrect SmallCode format. Cannot contain non-digit characters. Remember that it must be 3 characters long.");
    }

    public static String generateSmallCode() {
        StringBuilder sCo = new StringBuilder();
        Random rndm = new Random();

        for(int i = 0; i < 3; i++) {
            sCo.append(rndm.nextInt(0, 9));
        }

        return sCo.toString();
    }

    private boolean wrongSmallCodeFormat(String smallCode) {
        char[] smallCodeArray = smallCode.toCharArray();
        for(char c : smallCodeArray) {
            if(!Character.isDigit(c)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmallCode smallCode1 = (SmallCode) o;

        return smallCode.equals(smallCode1.smallCode);
    }

    @Override
    public int hashCode() {
        return smallCode.hashCode();
    }

    public String getSmallCode() {
        return smallCode;
    }

    @Override
    public String toString() {
        return "SmallCode{" + "smallCode='" + smallCode + '\'' + '}';
    }


}
