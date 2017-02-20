package pilot.autotest.common;

import org.assertj.swing.fixture.AbstractContainerFixture;

/**
 * GUIActions
 *
 * @author ext_azhuravlev2
 * @date 15.02.2017
 */
public interface GUIActions {
	
	void clickButton(AbstractContainerFixture container, String elementName);
	
	void printTextToField(AbstractContainerFixture container, String elementName, String inputText);
	
	boolean assertElementText(AbstractContainerFixture container, String elementName, String assertText);
}
