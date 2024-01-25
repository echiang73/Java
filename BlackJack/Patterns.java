public class Patterns {

    public static void main(String[] args) {
        printStars(7);
    }

    public static void printStars(int num) {
        // * * * * * 
        // * * * * * 
        // * * * * * 
        // * * * * * 
        // * * * * * 

        // for (int i=1; i<=num; i++) {
        //     for (int j=1; j<=num; j++) {
        //         System.out.print("* ");              
        //     }
        //     System.out.println();
        // }

        // for (int i=1; i<=num; i++) {
        //     System.out.println("* ".repeat(num));
        // }


        // * 
        // * * 
        // * * * 
        // * * * * 
        // * * * * * 

        // for (int i=1; i<=num; i++) {
        //     for (int j=1; j<=i; j++) {
        //         System.out.print("* ");              
        //     }
        //     System.out.println();
        // }

        // for (int i=1; i<=num; i++) {
        //     System.out.println("* ".repeat(i));
        // }


        // * * * * * 
        // * * * * 
        // * * * 
        // * * 
        // * 

        // for (int i=1; i<=num; i++) {
        //     for (int j=i; j<=num; j++) {
        //         System.out.print("* ");              
        //     }
        //     System.out.println();
        // }

        // for (int i=1; i<=num; i++) {
        //     System.out.println("* ".repeat(num+1-i));
        // }


        //         * 
        //       * * 
        //     * * * 
        //   * * * * 
        // * * * * * 

        // for (int i=1; i<=num; i++) {
        //     for (int j=i; j<=num; j++) {
        //         System.out.print("  ");              
        //     }
        //     for (int j=1; j<=i; j++) {
        //         System.out.print("* ");              
        //     }
        //     System.out.println();
        // }

        // for (int i=1; i<=num; i++) {
        //     System.out.print("  ".repeat(num+1-i));              
        //     System.out.println("* ".repeat(i));
        // }

        
        // for (int i=1; i<=num; i++) {
        //     for (int j=1; j<=num; j++) {
        //         if(i < num+1-j) {
        //             System.out.print("  "); 
        //         } else {
        //             System.out.print("* "); 
        //         }
        //     }
        //     System.out.println();
        // }


        // * * * * * 
        //   * * * * 
        //     * * * 
        //       * * 
        //         * 

        // for (int i=1; i<=num; i++) {
        //     for (int j=1; j<=i; j++) {
        //         System.out.print("  ");              
        //     }
        //     for (int j=i; j<=num; j++) {
        //         System.out.print("* ");              
        //     }
        //     System.out.println();
        // }

        // for (int i=1; i<=num; i++) {
        //     System.out.print("  ".repeat(i-1));              
        //     System.out.println("* ".repeat(num+1-i));
        // }


        //         * 
        //       * * * 
        //     * * * * * 
        //   * * * * * * * 
        // * * * * * * * * * 

        // for (int i=1; i<=num; i++) {
        //     for (int j=i; j<=num; j++) {
        //         System.out.print("  ");              
        //     }
        //     for (int j=1; j<i; j++) {
        //         System.out.print("* ");              
        //     }
        //     for (int j=1; j<=i; j++) {
        //         System.out.print("* ");              
        //     }
        //     System.out.println();
        // }

        // for (int i=1; i<=num; i++) {
        //     System.out.print("  ".repeat(num+1-i));              
        //     // System.out.print("* ".repeat(i-1));
        //     // System.out.println("* ".repeat(i));

        //     System.out.println("* ".repeat(i-1+i));
        // }


        // * * * * * * * * * 
        //   * * * * * * * 
        //     * * * * * 
        //       * * * 
        //         * 

        // for (int i=1; i<=num; i++) {
        //     for (int j=1; j<=i; j++) {
        //         System.out.print("  ");              
        //     }
        //     for (int j=i; j<num; j++) {
        //         System.out.print("* ");              
        //     }
        //     for (int j=i; j<=num; j++) {
        //         System.out.print("* ");              
        //     }
        //     System.out.println();
        // }

        // for (int i=1; i<=num; i++) {
        //     // System.out.print("  ".repeat(i-1));              
        //     // System.out.print("* ".repeat(num-i));
        //     // System.out.println("* ".repeat(num+1-i));

        //     // System.out.print("  ".repeat(i-1));              
        //     // System.out.println("* ".repeat(num-i+num+1-i));

        //     System.out.print("  ".repeat(i-1)); 
        //     System.out.println("* ".repeat(2*(num-i)+1));
        // }


        //         * 
        //       * * * 
        //     * * * * * 
        //   * * * * * * * 
        // * * * * * * * * * 
        //   * * * * * * * 
        //     * * * * * 
        //       * * * 
        //         * 

        // for (int i=1; i<=num; i++) {
        //     for (int j=i; j<=num; j++) {
        //         System.out.print("  ");              
        //     }
        //     for (int j=1; j<i; j++) {
        //         System.out.print("* ");              
        //     }
        //     for (int j=1; j<=i; j++) {
        //         System.out.print("* ");              
        //     }
        //     System.out.println();
        // }
        //  for (int i=2; i<=num; i++) {
        //     for (int j=1; j<=i; j++) {
        //         System.out.print("  ");              
        //     }
        //     for (int j=i; j<num; j++) {
        //         System.out.print("* ");              
        //     }
        //     for (int j=i; j<=num; j++) {
        //         System.out.print("* ");              
        //     }
        //     System.out.println();
        // }

        // for (int i=1; i<=num; i++) {
        //     System.out.print("  ".repeat(num+1-i));              
        //     System.out.println("* ".repeat(i-1+i));
        // }

        // for (int i=2; i<=num; i++) {
        //     System.out.print("  ".repeat(i)); 
        //     System.out.println("* ".repeat(2*(num-i)+1));
        // }

        
        // *           * 
        // * *       * * 
        // * * *   * * * 
        // * * * * * * * 
        // * * *   * * * 
        // * *       * * 
        // *           * 

        for (int i=1; i<=num/2; i++) {
            System.out.print("* ".repeat(i));
            System.out.print("  ".repeat(num-2*i));              
            System.out.println("* ".repeat(i));
        }
        System.out.println("* ".repeat(num));
        for (int i=1; i<=num/2; i++) {
            System.out.print("* ".repeat(((num+1)/2)-i));
            System.out.print("  ".repeat((i*2)-1));             
            System.out.println("* ".repeat(((num+1)/2)-i));
        }

    }
}