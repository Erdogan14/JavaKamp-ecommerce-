package ecommerce.core;

import ecommerce.Google.GoogleCheckin;

public class GoogleCheckinAdapter implements GoogleService {

	@Override
	public void registerToSystem(String message) {
		GoogleCheckin google = new GoogleCheckin();
		google.send(message);
		
	}

	
}
