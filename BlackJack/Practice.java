public class Practice {

    public static void main(String[] args) {
        printStars(7);
    }

    public static void printStars(int num) {
        // for (int i=1; i<num; i++) {
        //     for (int j=1; j<num; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // * 
        // * * 
        // * * * 
        // * * * * 
        // * * * * * 

        // for (int i=1; i<num; i++) {
        //     for (int j=1; j<i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // * * * * * 
        // * * * * 
        // * * * 
        // * * 
        // * 

        // for (int i=1; i<num; i++) {
        //     for (int j=i; j<num; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //         * 
        //       * * 
        //     * * * 
        //   * * * * 
        // * * * * * 

        // for (int i=1; i<num; i++) {
        //     for (int j=i; j<num; j++) {
        //         System.out.print(" ");
        //     }
        //     for (int j=1; j<i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // * * * * * 
        //   * * * * 
        //     * * * 
        //       * * 
        //         * 

        // for (int i=1; i<num; i++) {
        //     for (int j=1; j<i; j++) {
        //         System.out.print(" ");
        //     }
        //     for (int j=i; j<num; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //         * 
        //       * * * 
        //     * * * * * 
        //   * * * * * * * 
        // * * * * * * * * * 

        // for (int i=1; i<num; i++) {
        //     for (int j=i; j<num; j++) {
        //         System.out.print(" ");
        //     }
        //     for (int j=1; j<=i; j++) {
        //         System.out.print("*");
        //     }
        //     for (int j=1; j<i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // * * * * * * * * * 
        //   * * * * * * * 
        //     * * * * * 
        //       * * * 
        //         * 

        for (int i=1; i<num; i++) {
            for (int j=1; j<i; j++) {
                System.out.print(" ");
            }
            for (int j=i; j<num; j++) {
                System.out.print("*");
            }
            for (int j=i; j<num-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}