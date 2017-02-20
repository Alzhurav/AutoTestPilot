package pilot.autotest.common;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.dependency.jsr305.Nonnull;
import org.assertj.swing.fixture.AbstractContainerFixture;

import javax.swing.*;
import javax.swing.text.JTextComponent;

/**
 * GUIActionsAssertJ
 *
 * @author ext_azhuravlev2
 * @date 15.02.2017
 */
public class GUIActionsAssertJ implements GUIActions {
	
	@Override
	public void clickButton(AbstractContainerFixture container, final String elementName) {
		container.button(new GenericTypeMatcher<JButton>(JButton.class) {
			@Override
			protected boolean isMatching(@Nonnull JButton jButton) {
				return (jButton.getName() != null && jButton.getName().equals(elementName));
			}
		}).click();
	}
	
	@Override
	public void printTextToField(AbstractContainerFixture container, final String elementName, String inputText) {
		container.textBox(new GenericTypeMatcher<JTextComponent>(JTextComponent.class) {
			@Override
			protected boolean isMatching(@Nonnull JTextComponent jTextComponent) {
				return jTextComponent.getName() != null && jTextComponent.getName().equals(elementName);
			}
		}).deleteText().enterText(inputText);
	}
	
	@Override
	public boolean assertElementText(AbstractContainerFixture container,
	                                 final String elementName,
	                                 String assertText) {
		return container.textBox(new GenericTypeMatcher<JTextComponent>(JTextComponent.class) {
			@Override
			protected boolean isMatching(@Nonnull JTextComponent jTextComponent) {
				return jTextComponent.getName() != null && jTextComponent.getName().equals(elementName);
			}
		}).text().equals(assertText);
	}
}
