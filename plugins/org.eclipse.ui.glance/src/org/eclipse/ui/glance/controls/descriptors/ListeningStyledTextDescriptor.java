/*******************************************************************************
 * Copyright (c) 2017 Exyte
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Yuri Strot - initial API and implementation
 *******************************************************************************/
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
