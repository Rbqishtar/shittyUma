package entity;


public class App {
	public static void main(String[] args) throws InterruptedException {
		
		Uma[] horses = new Uma[9];
		horses[0] =  new Uma("01 Silence Suzuka", UmaType.NIGE);
		horses[1] =  new Uma("02 Toukai Teiou  ", UmaType.NIGE);
		horses[2] =  new Uma("03 Manhattan Café", UmaType.XIAN);
		horses[3] =  new Uma("04 Special Week  ", UmaType.XIAN);
		horses[4] =  new Uma("05 Daiwa Scarlet ", UmaType.SASHI);
		horses[5] =  new Uma("06 Nice Nature   ", UmaType.ZHUI);
		horses[6] =  new Uma("07 Mejiro McQueen", UmaType.XIAN);
		horses[7] =  new Uma("08 Rice Shower   ", UmaType.SASHI);
		horses[8] =  new Uma("09 Tamamo Cross  ", UmaType.XIAN);

		Field f = new Field("Test", horses.length, FieldLength.LONG, horses);
		f.race();
	}
}