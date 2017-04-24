/**
 * 
 */
package org.eclipse.ui.glance.controls.descriptors;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;

import org.eclipse.ui.glance.controls.text.styled.StyledTextSource;
import org.eclipse.ui.glance.sources.ITextSource;
import org.eclipse.ui.glance.sources.ITextSourceDescriptor;

/**
 * @author Yuri Strot
 * 
 */
public class StyledTextDescriptor implements ITextSourceDescriptor {

	public ITextSource createSource(Control control) {
		return new StyledTextSource((StyledText) control);
	}

	public boolean isValid(Control control) {
		return control instanceof StyledText;
	}

}
