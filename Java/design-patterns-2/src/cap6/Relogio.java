package cap6;

import java.util.Calendar;

public class Relogio implements RelogioGenerico {

	@Override
	public Calendar hoje() {
		return Calendar.getInstance();
	}
}
