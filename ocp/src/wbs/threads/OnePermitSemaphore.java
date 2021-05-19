package wbs.threads;

public class OnePermitSemaphore {
	private boolean isFree = true;
 // age 3 ta hamzaman bian va 3 tashoon aquire bian yekishoo miad migire va 2 tashoo miad too block mimoone va badesh mimoone too waiting
	public void acquire() throws InterruptedException {
		synchronized (this) {
			while (!this.isFree) {
				this.wait();
			}
			this.isFree = false;
		}
	}

	public void release() throws InterruptedException {
		synchronized (this) {
			this.isFree = true;
			this.notifyAll();
		}
	}
}
