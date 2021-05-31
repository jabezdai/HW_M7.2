package swimpool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Price {
	public int swimprice(int member,int week,String time,int group,int age) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
		Date open = sdf.parse("05:00");
		Date close = sdf.parse("22:00");
		Date partytime = sdf.parse("07:00");
		Date now = sdf.parse(time);
		if(now.before(open) || now.after(close)) {
			throw new Exception();
		}else if(week < 1 || week >7) {
			throw new Exception();
		}else if(age < 3 || age > 75 ) {
			throw new Exception();
		}
		
		if(week == 6 || week == 7) {
			if(member == 1) {
				return 125;
			}else {
				return 250;
			}
		}else {
			if(member == 1) {
				return 100;
			}else if( group == 1) {
				return 140;
			}else if(now.before(partytime)){
				return 160;
			}else if(age < 13 || age > 59) {
				return 160;
			}else {
				return 200;
			}
		}
		
	}
	public int racingprice(int teacher,int student,String[] time) throws Exception{
		int j=0;
		String[] timestep = {"A","B","C","D","E"};
		for(int i=0;i<time.length;i++) {
			for(j=i+1;j<time.length;j++) {
				if(time[i].equals(time[j])) {
					throw new Exception();
				}

			}
		}
		for(int i=0;i<time.length;i++) {
			for(j=0;j<timestep.length;j++) {
				if(time[i].equals(timestep[j])) {
					break;
				}
			}
			if(j == timestep.length) {
				throw new Exception();
			}
		}
		if(teacher<1) {
			throw new Exception();
		}else if(teacher+student<10) {
			return 3000*time.length*2;
		}else {
			return (teacher*120+student*70)*time.length;
		}
	}
}
