import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UF2ACT2 {

    public static void main(final String... args) throws InterruptedException, ExecutionException {
        //mostrem hora actual abans d�execuci�
    Calendar calendario = new GregorianCalendar();
    System.out.println("Inici: "+ calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE) +
        ":" + calendario.get(Calendar.SECOND));
    // Crea un pool de 2 fils
    final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(2);
    // Crea objecte Runnable.
    final Runnable ob = new UF2ACT2().new ExecutaFil();
    // Programa Fil, s�inicia als 2 segons i despr�s es va executant cada 3 segons
    schExService.scheduleWithFixedDelay(ob, 2, 3, TimeUnit.SECONDS);
    // Espera per acabar 10 segons
    schExService.awaitTermination(10, TimeUnit.SECONDS);
    // shutdown .
    schExService.shutdownNow();
    System.out.println("Completat");
    }

    // Fil Runnable
    class ExecutaFil implements Runnable {
        @Override
        public void run() {
            Calendar calendario = new GregorianCalendar();
            System.out.println("Hora execuci� tasca: "+
                calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                calendario.get(Calendar.MINUTE) + ":" +
                calendario.get(Calendar.SECOND));
            System.out.println("Tasca en execuci�");
            System.out.println("Execuci� acabada");
            }
        }
    }