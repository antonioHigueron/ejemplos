package main.java.io.acaeronte;

public class VolatileKeyword {

    private static int counterCache = 0;
    private static volatile int counterDirectCpu = 0;

    public static void main(String[] args) {
        notCommunicationBetweenThreads();
        communicationBetweenThreads();

    }

    /**
     * si se marca una variable como volatile, significa que su valor
     * actual se guarda en la cpu directamente, y es accedida desde
     * todos los procesos, hilos.. pero empeora el rendimiento, aunque
     * si cambia, todos los procesos se hacen eco, sino es volatile
     * cuando un proceso cambia su valor se almacena en una cache de la
     * cpu, que no tarda en actualizarse en la cpu, pero no es
     * inmediato, como si lo sería en el caso de ser volatile, es una
     * cuestion de rendimiento(variables no volatile).
     * {@link https://www.youtube.com/watch?v=V2hC-g6FoGc&t=21s}
     */
    private static void communicationBetweenThreads() {
        Thread t1 = new Thread( ()-> {
            int localCounter = counterDirectCpu;
            while (localCounter < 10){
                System.out.println("no cambia");
                if (localCounter != counterDirectCpu){
                    System.out.println("[T1] Contador local ha cambiado");
                    localCounter = counterDirectCpu;
                }
            }
        });

        Thread t2 = new Thread( ()-> {
            int localCounter = counterDirectCpu;
            while (localCounter < 10){
                System.out.println("[T2] Incrementando contador a "+ (localCounter+1) );
                counterDirectCpu = ++localCounter;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void notCommunicationBetweenThreads() {
        Thread t1 = new Thread( ()-> {
            int localCounter = counterCache;
            while (localCounter < 10){
                if (localCounter != counterCache){
                    System.out.println("[T1] Contador local ha cambiado");
                    localCounter = counterCache;
                }
            }
        });

        Thread t2 = new Thread( ()-> {
            int localCounter = counterCache;
            while (localCounter < 10){
                System.out.println("[T2] Incrementando contador a "+ (localCounter+1) );
                counterCache = ++localCounter;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

    }

}
