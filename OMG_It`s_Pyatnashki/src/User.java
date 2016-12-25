
public class User {
	private String name; // Р пїЅР С�РЎРЏ Р С—Р С•Р В»РЎРЉР В·Р С•Р Р†Р В°РЎвЂљР ВµР В»РЎРЏ
	private double bestGameTime;  // Р вЂ™РЎР‚Р ВµР С�РЎРЏ Р В»РЎС“РЎвЂЎРЎв‚¬Р ВµР в„– Р С‘Р С–РЎР‚РЎвЂ№
	private double fullGameTime; // Р С›Р В±РЎвЂ°Р ВµР Вµ Р Р†РЎР‚Р ВµР С�РЎРЏ Р Р†РЎРѓР ВµРЎвЂ¦ Р С‘Р С–РЎР‚ (РЎРѓРЎС“Р С�Р С�Р В°)
	private double lastGameTime; // Р Р†РЎР‚Р ВµР С�РЎРЏ Р С—Р С•РЎРѓР В»Р ВµР Т‘Р Р…Р ВµР в„– Р С‘Р С–РЎР‚РЎвЂ№

	
	public User(String name, double bestGameTime, double lastGameTime, double fullGameTime){
		 this.name = name;
		 this.bestGameTime = bestGameTime;
		 this.fullGameTime = fullGameTime;
		 this.lastGameTime = lastGameTime;
	}
	
	public String getName(){
		return name;
	}
	
	public double getTime(){
		return lastGameTime;
	}
	
	public double getBestGame(){
		return bestGameTime;
	}
	
	public double getFullTime(){
		return fullGameTime;
	}
	
	public void incStat(double t){
		fullGameTime += t;
		lastGameTime = t;
		
		if( t < bestGameTime ){
			bestGameTime = t;
		}
	}
	
	public String toString(){
        return name + ";" + bestGameTime + ";" + lastGameTime + ";"  + fullGameTime + ";";
	}
	
}
