package entity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Field {
	
	private String name;
	private String[] field;
	private Uma[] umaOnField;
	private int len;
	private int umaCount;
	private ArrayList<String> umaRank;
	private ArrayList<String> umaTime;
	private int finishNum = 0;
	private long startTime;

	public void addFinishNum() {
		this.finishNum += 1;
	}

	public void concatRank(String x) {
		umaRank.add(x);
	}

	public void concatTime(String x) {
		umaTime.add(x);
	}

	Field(String name, int umaCount, int length, Uma[] uma) {
		this.umaCount = umaCount;
		this.name = name;
		len = length;
		String[] x = new String[3*umaCount + 1];
		field = x;
		umaOnField = uma;
		umaRank = new ArrayList<String>();
		umaTime = new ArrayList<String>();
		startTime = System.currentTimeMillis();
		
		String doubleDash="";
		String singleDash="";
		for (int i=0; i<len; i++) {
			doubleDash = doubleDash.concat("=");
			singleDash = singleDash.concat("");
		}
		
		field[0] = doubleDash;
		for (int i=1; i<umaCount; i++) {
			field[3*i] = singleDash;
			field[3*i - 1] = umaOnField[i-1].getTrack();
			field[3*i - 2] = umaOnField[i-1].getName();
		}
		field[3*umaCount - 2] = umaOnField[umaCount-1].getName();
		field[3*umaCount - 1] = umaOnField[umaCount-1].getTrack();
		field[3*umaCount] = doubleDash;
	}
	
	public void printField() {

		long elapsedTime = System.currentTimeMillis() - startTime;
		double x = elapsedTime / 1000.0;
		DecimalFormat df = new DecimalFormat("#.000");

		for (int i=0; i<field.length; i++) {
			System.out.print("||");
			System.out.print(field[i] + "\n");
		}
		System.out.println("Time: " + df.format(x) + "s");
		System.out.println("\n");
	}
	
	public void printResult() {
		for (int i=0; i<umaCount; i++) {
			System.out.println( (i+1) + "位: \t" + umaRank.get(i) + "\t" + umaTime.get(i) + "s");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.exit(0);
	}

	public void race() throws InterruptedException {
		while (true) {
			if (finishNum == umaCount) {
				printResult();
			}
			Thread.sleep(50);
			for (int i=0; i<umaCount; i++) {
				umaOnField[i].run(this);
				field[3*(i+1)-1] = umaOnField[i].getTrack();
			}
			this.printField();
		}
	}
	
	public int getLength() {
		return len;
	}
	
}

