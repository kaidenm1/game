import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FancyPrinter {
  private final ScheduledExecutorService executor;

  public FancyPrinter() {
    this.executor = new ScheduledThreadPoolExecutor(1);
  }

  public void fancyPrint(Object obj) {
    String s;
    if (obj instanceof String) {
      s = (String) obj;
    } else if (obj instanceof Integer) {
      s = obj.toString();
    } else {
      throw new IllegalArgumentException("obj must be a String or an Integer");
    }

    for (char c : s.toCharArray()) {
      executor.schedule(() -> System.out.print(c), 70, TimeUnit.MILLISECONDS);
    }
  }
}