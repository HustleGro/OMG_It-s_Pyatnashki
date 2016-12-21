
public class User {
	private String name; // Р�РјСЏ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
	private double bestGameTime;  // Р’СЂРµРјСЏ Р»СѓС‡С€РµР№ РёРіСЂС‹
	private double fullGameTime; // РћР±С‰РµРµ РІСЂРµРјСЏ РІСЃРµС… РёРіСЂ (СЃСѓРјРјР°)
	private double lastGameTime; // РІСЂРµРјСЏ РїРѕСЃР»РµРґРЅРµР№ РёРіСЂС‹

	public void setUser(String name1, Integer gameTime, double date){
		this.name = name1;
		this.bestGameTime = gameTime;
		this.lastGameTime = date;
		this.fullGameTime = gameTime;
	}
	
	public User(String name, double bestGameTime, double fullGameTime, double lastGameTime){
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
	
	
}
