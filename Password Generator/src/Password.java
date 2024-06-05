
public class Password {
    String Value;
    int Length;

    public Password(String s) {
        Value = s;
        Length = s.length();
    }


    // Criteria of rating
    public int CharType(char C) {
        int val;

        // uppercase
        if ((int) C >= 65 && (int) C <= 90)
            val = 1;

        // lowercase
        else if ((int) C >= 97 && (int) C <= 122) {
            val = 2;
        }

        // nums
        else if ((int) C >= 60 && (int) C <= 71) {
            val = 3;
        }

        // symbols
        else {
            val = 4;
        }

        return val;
    }

    // System of rating

    public int PasswordStrength() {
        String s = this.Value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedUpperUkr = false;
        boolean UsedLowerUkr = false;
        boolean UsedNum = false;
        boolean UsedSym = false;
        int type;
        int Score = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            type = CharType(c);

            if (type == 1) UsedUpper = true;
            if (type == 2) UsedLower = true;
            if (type == 3) UsedUpperUkr = true;
            if (type == 4) UsedLowerUkr = true;
            if (type == 5) UsedNum = true;
            if (type == 6) UsedSym = true;
        }

        if (UsedUpper) Score += 1;
        if (UsedLower) Score += 1;
        if (UsedUpperUkr) Score += 1;
        if (UsedLowerUkr) Score += 1;
        if (UsedNum) Score += 1;
        if (UsedSym) Score += 1;

        if (s.length() >= 8) Score += 1;
        if (s.length() >= 16) Score += 1;

        return Score;
    }
    // Answers
    public String calculateScore() {
        int Score = this.PasswordStrength();

        if (Score >= 6) {
            return "It's very strong password! :D \n" +
                    "Du u want to read information how to improve it?";
        } else if (Score >= 4) {
            return "That's good password ! :) \n" +
                    "But u can better!";
        } else if (Score >= 3) {
            return "That's normal password :/ \n" +
                    "Should we improve it?";
        } else {
            return "U'r password is weak :( \n" +
                    "Let's make something stronger!";
        }
    }

    @Override
    public String toString() {
        return Value;
    }
}
