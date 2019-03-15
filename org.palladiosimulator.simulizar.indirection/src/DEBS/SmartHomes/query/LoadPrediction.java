package DEBS.SmartHomes.query;

import java.util.Map;
import java.util.function.*;

import DEBS.SmartHomes.data.In;
import DEBS.SmartHomes.data.Out2;
import DEBS.SmartHomes.data.sructure.CircularList;

public class LoadPrediction implements Consumer<In>, Supplier<Out2> {
	
	private long house_id = 0L; 
	private final Map<Long, CircularList> tets = null;
	
	public Out2 get() {
		// TODO Auto-generated method stub
		return null;
	}

	public void accept(In t) {
		// TODO Auto-generated method stub
		
	}

}
