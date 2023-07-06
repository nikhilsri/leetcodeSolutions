public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
int len_s = s.length();
        int len_t = t.length();

        if (k < Math.abs(len_s - len_t)) {
            return "No";
        }

        if (k >= len_s + len_t) {
            return "Yes";
        }

        int common_len = 0;
        while (common_len < len_s && common_len < len_t && s.charAt(common_len) == t.charAt(common_len)) {
            common_len++;
        }

        int remaining_moves = k - (len_s + len_t - 2 * common_len);
        if (remaining_moves >= 0 && remaining_moves % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }
