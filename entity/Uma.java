package entity;

import java.text.DecimalFormat;

public class Uma {
	
	private double run_freq = 0.2;
	private String name;
	private String track="";
	private int type;
	private int goal;
	private long startTime;
	private long endTime;
	private long runTime;
	private boolean isFinished = false;
	
	Uma() {
		
	}
	
	Uma(String name, int type) {
		this.name = name;
		this.type = type;
		this.startTime = System.currentTimeMillis();
	}
	
	public String getTrack() {
		return this.track;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void run(Field f) throws InterruptedException {
		
		//get info of field
		goal = f.getLength();
		if (goal == 0) {
			System.out.println("field getLength error");
			System.exit(-1);
		}
		
		//if finish -> log time, stop running
		double propotion = this.track.length()/goal;		
		if (propotion == 1 && !isFinished) {
			//finished
			this.endTime = System.currentTimeMillis();
			this.runTime = endTime - startTime;
			double x = runTime / 1000.0;
			DecimalFormat df = new DecimalFormat("#.000");
			f.concatRank(this.name);
			f.concatTime(df.format(x));
			track = track.concat("\t" + df.format(x));
			f.addFinishNum();
			this.isFinished = true;
		}
		
		//running
		double a = Math.random();
		if (run_freq > a && !isFinished) {
			if (run_freq > a*40) {
				track = track.concat(">>>>>");
			}
			else track = track.concat(">");
		}
	}
}
