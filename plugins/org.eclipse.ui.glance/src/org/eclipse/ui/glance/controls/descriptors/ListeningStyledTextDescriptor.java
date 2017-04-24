/**
 * 
 */
package org.eclipse.ui.glance.controls.descriptors;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;

import org.eclipse.ui.glance.controls.text.styled.ListeningStyledTextSource;
import org.eclipse.ui.glance.sources.ITextSource;
import org.eclipse.ui.glance.sources.ITextSourceDescriptor;

/**
 * @author Yuri Strot
 * 
 */
public class ListeningStyledTextDescriptor implements ITextSourceDescriptor {

	public ITextSource createSource(Control control) {
		return new ListeningStyledTextSource((StyledText) control);
	}

	public boolean isValid(Control control) {
		if (control instanceof StyledText) {
			StyledText text = (StyledText) control;
			return text.isListening(LineGetStyle);
		}
		return false;
	}

	static final int LineGetStyle = 3002;

}
