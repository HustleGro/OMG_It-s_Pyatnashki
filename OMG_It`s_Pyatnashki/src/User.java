
public class User {
	private Integer bestGameTime;  // Время последней игры
	private String name; // Имя пользователя
	private Integer fullGameTime; // Общее время всех игр (сумма)
	private String lastGameDate; // дата последней игры

	public void setUser(String name1, Integer gameTime, String date){
		name = name1;
		bestGameTime = gameTime;
		lastGameDate = date;
		fullGameTime += gameTime;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDate(){
		return lastGameDate;
	}
	
	public Integer getBestGame(){
		return bestGameTime;
	}
	
	public Integer getFullTime(){
		return fullGameTime;
	}
	
	
}
