package Java.reusableFunations;

import java.util.List;
import java.util.Set;

public interface UseWebDriverElements {

	String useWebElement(LocatorsList locator, String Locator_Value, ActionTypeList action, String action_values,String logValue);

	List<String> useWebElements(LocateBy By, String LocatorsList_Value, ActionTypeList action, String action_values, String logValue);

	String useWebWindow();

	Set<String> useWebWindows();

	void frame();

}
