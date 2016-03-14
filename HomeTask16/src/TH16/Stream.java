package TH16;

public class Stream extends Thread {
	Task1and2 task;

	boolean sync;

	public Stream(Task1and2 task) {
		this.task = task;
	}

	public Stream(Task1and2 task, boolean sync) {
		this.sync = sync;
		this.task = task;
	}

	@Override
	public void run() {
		if (this.sync) {
			synchronized (this.task) {
				this.task.print10(this);
			}
		} else {
			this.task.print10(this);
		}

	}
}
