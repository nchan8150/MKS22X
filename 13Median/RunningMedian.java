public class RunningMedian{

	private int size;


	public RunningMedian() {
		size = 0;
	}

	public void add (Double added) {

	}

	public Double getMedian() {
		if(size == 0) {
			throw new NoSuchElementException();
		}

	}

	public int size() {
		return size;
	}	
}
