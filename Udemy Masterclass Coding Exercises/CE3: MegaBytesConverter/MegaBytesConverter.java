// Basic solution
public class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0){
            System.out.println("Invalid Value");
        } else {
            int mb = kiloBytes / 1024;
            int remainingKb = kiloBytes % 1024;
            System.out.println(kiloBytes +" KB = "+ mb + " MB and " + remainingKb + " KB");
        }
    }
}

// Alternative solution using ternary operator
public class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        int mb = kiloBytes / 1024;
        int remainingKb = kiloBytes % 1024;
        System.out.println(kiloBytes < 0 ? "Invalid Value" : (kiloBytes +" KB = "+ mb + " MB and " + remainingKb + " KB"));
    }
}
