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
}
