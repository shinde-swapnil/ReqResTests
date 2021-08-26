package TestCases;

import org.testng.annotations.Test;

import TestUtils.payload;
import io.restassured.path.json.JsonPath;

public class JsonPathTest {

	@Test
	public void test1() {
		/* String dashboardJSON= */

		JsonPath jp2 = new JsonPath(payload.dashboardJSON());

		// System.out.println("webautomation array size:" + webautomationSize);

		// Courses available under Web Automation
		int webAutomationSize = jp2.getInt("courses.webautomation.size()");

		// Courses available under API Automation
		int apiAutomationSize = jp2.getInt("courses.api.size()");

		// Courses available under Mobile Automation
		int mobileAutomationSize = jp2.getInt("courses.Mobile_Automation.size()");

		System.out.println(" " + webAutomationSize + apiAutomationSize + mobileAutomationSize);

		// Name of Courses in Web Automation Track
		System.out.println("Courses in Web Automation Track: ");
		for (int i = 0; i < webAutomationSize; i++) {
			System.out.println(
					"Web Automation Course-" + i + " :" + jp2.getString("courses.webautomation[" + i + "].title"));
		}

		// Name of Courses in API Automation Track
		System.out.println("Courses in API Automation Track: ");
		for (int i = 0; i < apiAutomationSize; i++) {
			System.out.println("API Automation Course-" + i + " :" + jp2.getString("courses.api[" + i + "].title"));
		}

		// Name of Courses in Mobile Automation Track
		System.out.println("Courses in Mobile Automation Track: ");
		for (int i = 0; i < mobileAutomationSize; i++) {
			System.out.println("Mobile Automation Course-" + i + " :"
					+ jp2.getString("courses.Mobile_Automation[" + i + "].title"));
		}

		// Price of Module Web Automation

		int webAutomationPrice = 0;
		for (int i = 0; i < webAutomationSize; i++) {
			int coursePrice = jp2.getInt("courses.webautomation[" + i + "].price");
			webAutomationPrice = webAutomationPrice + coursePrice;

		}
		System.out.println("Web Automation Price : " + webAutomationPrice);

		// Price of Module API Automation

		int apiAutomationPrice = 0;
		for (int i = 0; i < apiAutomationSize; i++) {
			int coursePrice = jp2.getInt("courses.api[" + i + "].price");
			apiAutomationPrice = apiAutomationPrice + coursePrice;

		}
		System.out.println("API Automation Price : " + apiAutomationPrice);

		// Price of Module Web Automation

		int mobileAutomationPrice = 0;
		for (int i = 0; i < mobileAutomationSize; i++) {
			int coursePrice = jp2.getInt("courses.Mobile_Automation[" + i + "].price");
			mobileAutomationPrice = mobileAutomationPrice + coursePrice;

		}
		System.out.println("Mobile Automation Price : " + mobileAutomationPrice);

		// Total Price of Courses
		
		int totalPrice = jp2.getInt("dashboard.purchaseAmount");
		
		if((webAutomationPrice+apiAutomationPrice+mobileAutomationPrice) == totalPrice)
		{
			System.out.println("Purchase amount matches with Combined price of all three courses and i.e. 40000");
		}
		

	}
}
