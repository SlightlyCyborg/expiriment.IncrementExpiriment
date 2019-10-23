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

    public static int[] getNRandomInts(int n) {
        int[] rv = new int[n];
        for(int i = 0; i < n; i++) {
            rv[i] = random.nextInt();
        }
        return rv;
    }

    public static long runSimpleAddition(int n) {
        long start, stop;
        int[] a = getNRandomInts(n);
        int[] b = getNRandomInts(n);

        start = System.nanoTime();
        for(int i = 0; i < n; i++) {
            simpleAdd(a[i], b[i]);
        }
        stop = System.nanoTime();
        return stop-start;
    }

    public static long runIncrementAddition(int n) {
        long start, stop;
        int[] a = getNRandomInts(n);
        int[] b = getNRandomInts(n);

        start = System.nanoTime();
        for(int i = 0; i < n; i++) {
            incrementAdd(a[i], b[i]);
        }
        stop = System.nanoTime();
        return stop-start;
    }

    public static void main(String[] args) {
        int numIterations = getNumIterations(args);
        long time;

        String msg;

        time = runSimpleAddition(numIterations);
        msg = "   Simple addition for %d iterations took %d nanosecs\n";
        System.out.printf(msg, numIterations, time);

        time = runIncrementAddition(numIterations);
        msg = "Increment addition for %d iterations took %d nanosecs\n";
        System.out.printf(msg, numIterations, time);
    }
}
