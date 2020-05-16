package homework;

public class FullPermutation {

    public static void fullPermutation() {
        String string = "abcd";

        char[] cs = string.toCharArray();

        Permutation(cs, 0, cs.length);

    }

    private static void Permutation(char[] cs, int start, int end) {
        if (start == end) {
            System.out.println(new String(cs));
        } else {
            for (int i = start; i < end; i++) {
                swap(cs, start,i);
                Permutation(cs, start + 1, end);
                swap(cs, i, start);
            }
        }
    }

    private static void swap(char[] cs, int i, int end) {
        char temp = cs[i];
        cs[i] = cs[end];
        cs[end] = temp;
    }

    public static void main(String[] args) {
        fullPermutation();
    }
}
