import java.util.Random;

class IncrementExpiriment {
    static Random random = new Random();

    private static int incrementAdd(int a, int b) {
        for(int i=0; i<Math.abs(b); i++)
            if(b>0) a++; else a--;
        return a;
    }

    private static int simpleAdd(int a, int b) {
        return a + b;
    }

    public static void printUsageAndDie() {
        String usage = "usage: IncrementExpiriment <numAdditionsToRun>";
        System.out.println(usage);
        System.exit(1);
    }

    public static int getNumIterations (String[] args) {
        int rv = -1;

        if(args.length < 1) printUsageAndDie();

        try {rv = Integer.parseInt(args[0]);}
        catch (Exception e) {printUsageAndDie();}

        return rv;
    }

    public static void runSimpleAddition(int n) {
        int a, b;
        for(int i = 0; i < n; i++) {
            a = random.nextInt();
            b = random.nextInt();
            simpleAdd(a, b);
        }
    }

    public static void runIncrementAddition(int n) {
        int a, b;
        for(int i = 0; i < n; i++) {
            a = random.nextInt();
            b = random.nextInt();
            incrementAdd(a, b);
        }
    }

    public static void main(String[] args) {
        int numIterations = getNumIterations(args);

        String msg;
        long start, stop;

        start = System.nanoTime();
        runSimpleAddition(numIterations);
        stop = System.nanoTime();
        msg = "   Simple addition for %d iterations took %d nanosecs\n";
        System.out.printf(msg, numIterations, stop-start);

        start = System.nanoTime();
        runIncrementAddition(numIterations);
        stop = System.nanoTime();
        msg = "Increment addition for %d iterations took %d nanosecs\n";
        System.out.printf(msg, numIterations, stop-start);
    }
}
