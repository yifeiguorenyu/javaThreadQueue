
public class Queue {
  private int n;
  boolean flag = false;

public synchronized int getN() {
	if(!flag) {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	System.out.println("消费"+n);
	flag =false;
	notifyAll();
	return n;
}

public synchronized void setN(int n) {
	if(flag) {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	System.out.println("生产"+n);
	this.n = n;
	flag=true;
	notifyAll();
}


}
