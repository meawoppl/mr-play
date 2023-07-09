package mpersist;

import java.util.concurrent.atomic.AtomicInteger;
import mpersist.generators.BigPrimeGenerator;

public class PrimeGrinderEntryPoint {
  public static void main(String[] args) {

    int bits = 273;
    BigPrimeGenerator generator = new BigPrimeGenerator(bits);

    AtomicInteger ai = new AtomicInteger(0);
    generator
        .toParallelStream()
        .peek(
            (v) -> {
              int n = ai.addAndGet(1);
              if (n % 10000 == 0) {
                System.out.println(String.format("Searched %d primes of bit length %d", n, bits));
              }
            })
        .filter((p) -> Persistence.compute(p) >= 3)
        .forEach(
            (p) -> {
              throw new RuntimeException(p.toString());
            }
        );
  }
}
