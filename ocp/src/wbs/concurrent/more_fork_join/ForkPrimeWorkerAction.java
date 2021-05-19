package wbs.concurrent.more_fork_join;

import java.math.BigInteger;
import java.util.concurrent.RecursiveAction;

public class ForkPrimeWorkerAction extends RecursiveAction {

	private static final long serialVersionUID = 1L;

	private static final BigInteger TWO = BigInteger.valueOf(2);
	private final BigInteger untergrenze;
	private final BigInteger obergrenze;

	private static BigInteger maxInterval = BigInteger.valueOf(100_000);
	private static boolean isPrinting = true;

	private static BigInteger total = BigInteger.ZERO;

	public ForkPrimeWorkerAction(BigInteger untergrenze, BigInteger obergrenze) {
		this.untergrenze = untergrenze;
		this.obergrenze = obergrenze;
	}

	public static void setMaxInterval(BigInteger maxInterval) {
		ForkPrimeWorkerAction.maxInterval = maxInterval;
	}

	public static void setPrinting(boolean isPrinting) {
		ForkPrimeWorkerAction.isPrinting = isPrinting;
	}

	public static synchronized BigInteger getTotal() {
		return total;
	}

	@Override
	public void compute() {

		BigInteger interval = obergrenze.subtract(untergrenze);

		if (interval.compareTo(maxInterval) <= 0) {
			// intervall ist klein genug. rechne.
			BigInteger anzahl = BigInteger.ZERO;
			BigInteger var = new BigInteger(untergrenze.toByteArray());
			// ohne optimierung
			for (; var.compareTo(obergrenze) <= 0; var = var.add(BigInteger.ONE)) {
				if (var.isProbablePrime(40)) {
					anzahl = anzahl.add(BigInteger.ONE);
				}
			}
			if (isPrinting) {
				System.out.printf("%s comp [%,12d%,12d] -> %,12d%n", Thread.currentThread().getName(), untergrenze,
						obergrenze, anzahl);
			}

			synchronized (total) {
				total = total.add(anzahl);
			}
		} else {
			BigInteger mid = (untergrenze.add(obergrenze)).divide(TWO);
			if (isPrinting) {
				System.out.printf("%s fork " + "[%,12d%,12d]<->[%,12d%,12d]%n", Thread.currentThread().getName(),
						untergrenze, mid, mid.add(BigInteger.ONE), obergrenze);
			}

			ForkPrimeWorkerAction firstWorker = new ForkPrimeWorkerAction(untergrenze, mid);
			ForkPrimeWorkerAction secondWorker = new ForkPrimeWorkerAction(mid.add(BigInteger.ONE), obergrenze);

			invokeAll(firstWorker, secondWorker);
		}
	}

}
