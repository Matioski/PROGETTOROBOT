package robot;

public abstract class Item {
	public Worker owner;
	public Worker getWorker(){
		return owner;
	}
}
