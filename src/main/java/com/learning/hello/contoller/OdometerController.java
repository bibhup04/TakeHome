package com.learning.hello.contoller;
import java.util.Random;



public class OdometerController {
private static final String DIGITS = "123456789";
	
	private int reading;
	
	private static int getMinReading(int size) {
		return Integer.valueOf(DIGITS.substring(0, size));
	}
	
	private static int getMaxReading(int size) {
		return Integer.valueOf(DIGITS.substring(DIGITS.length() - size, DIGITS.length()));
	}
	
	private static int getSize(int reading) {
		return String.valueOf(reading).length();
	}
	
	public OdometerController(int size) {
		reading = getMinReading(size);
	}
	
	public OdometerController(OdometerController copy) {
		reading = copy.reading;
	}
	
	public int getReading() {
		return reading;
	}
	
	public boolean setReading(int reading)
		{if (!isAscending(reading))
			return false;
		else if (getSize(reading) != getSize(this.reading))
			return false;
			
		else 
			this.reading = reading;
		return true;
	
	}
	
	@Override
	public String toString() {
		return String.valueOf(reading);
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof OdometerController))
			return false;
		OdometerController otherOdo = (OdometerController) other;
		return otherOdo.reading == this.reading;
	}
	
	public static boolean isAscending(int reading) {
		if (reading < 10)
			return true;
		if(reading % 10 <= (reading / 10) % 10)
			return false;
		return isAscending(reading / 10);
	}
	
	
	public void incrementReading() {
		do {
			if (reading == getMaxReading(getSize(reading)))
				reading = getMinReading(getSize(reading));
			else
				reading++;
		} while (!isAscending(reading));
	}
	 
	public OdometerController nextReading() {
		OdometerController temp = new OdometerController(this);
		temp.incrementReading();
		return temp;
	} 
	
	public void decrementReading() {
		do {
			if (reading == getMinReading(getSize(reading)))
				reading = getMaxReading(getSize(reading));
			else
				reading--;
		} while (!isAscending(reading));
	}
	
	public void reset() {
		this.reading = getMinReading(getSize(this.reading));
	}
	
	public int getSize() {
		return getSize(this.reading);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private int correct;
	  private int guess;
	  
	  public void setGuess(int guess) {
	    this.guess = guess;
	  }
	  
	  public void resets() {
	    this.correct = new Random().nextInt(0, 100);
	  }
	  
	  public int judge() {
	    return Integer.compare(guess, correct);
	  }
	  
	  public String feedback() {
	    return judge() == 0 ? "Correct!" : judge() == 1 ? "Guess lower" : "guess higher";
	  }

}
