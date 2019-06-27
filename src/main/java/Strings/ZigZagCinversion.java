package Strings;

public class ZigZagCinversion {

    public static void main(String[] args){

        System.out.println(convert("PAYPALISHIRING" , 3));
    }

    public static String convert(String s, int n) {

        // create n string buffer and add elements to them by first traversing down and then oblique up and so on
        // while traversing , keep checking that i is in boundaries of string length.

        StringBuffer[] sb = new StringBuffer[n];

        for(int i = 0; i < n; i++){
            sb[i] = new StringBuffer();
        }

        for(int i = 0; i < s.length();){

            //
            for(int idx = 0; idx < n && i < s.length(); idx++ , i++){
                sb[idx] = sb[idx].append(s.charAt(i));
            }

            for(int idx = n-2; idx > 0 && i < s.length(); idx-- , i++) {

                sb[idx] = sb[idx].append(s.charAt(i));

            }
        }

        // traverse through all string buffers and just append them
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < n; i++){
            res.append(sb[i]);
        }

        return res.toString();

    }
}
