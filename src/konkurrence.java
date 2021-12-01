// Dannie
/*public class Konkurrence {
    public void konkurrence() {
        int juniorSwimmer = 0;
        int seniorSwimmer = 1;

        String[] a = {"Runner", " Sex", " Age", "    Min"};
        String[][] b = {
                {"  3457", "   1", "  41", "     39"},
        };

        //array int
        int[][] c = {
                {3457, 1, 41, 39},
        };

        //for print title
        for (String heading : a) {
            System.out.print("|" + heading + "|");
        }
        System.out.println("\n-----------------------------");
        //for print numb
        for (int i = 0; i < b.length; ++i) {
            for (int j = 0; j < b[i].length; ++j) {
                System.out.println(
                        String.format("|%6d||%4d||%4d||%7d|\n-----------------------------",
                                c[0], c[1], c[2], c[3]));
            }
            //for to find the minimun time of junior
            for (int i = 0; i < 7; i++) {
                if (c[i][1] == 1) {
                    if (c[i][3] < c[juniorSwimmer][3]) {
                        juniorSwimmer = i;
                    }
                    //else to find the minimum of senior
                } else {
                    if (c[i][1] == 0) {
                        if (c[i][3] < c[seniorSwimmer][3]) {
                            seniorSwimmer = i;
                        }
                    }
                }//end else
            }//end for

            //for to print the winners
            for (int i = 0; i < 1; i++) {
                System.out.print("Runner num " + c[juniorSwimmer][0]
                        + " with an age of " + c[juniorSwimmer][2]
                        + " and time of " + c[juniorSwimmer][3]
                        + " min is the male winner.");
                System.out.println("");

                System.out.print("Runner num " + c[seniorSwimmer][0]
                        + " with an age of " + c[seniorSwimmer][2]
                        + " and time of " + c[seniorSwimmer][3]
                        + " min is the female winner.");
            }
        }
    }
}*/