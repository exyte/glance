/*******************************************************************************
 * Copyright (c) 2017 Exyte
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Yuri Strot - initial API and Implementation
 ******************************************************************************/
package org.eclipse.ui.glance.viewers.descriptors;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;

import org.eclipse.ui.glance.sources.ITextSourceDescriptor;
import org.eclipse.ui.glance.viewers.utils.ViewerUtils;

/**
 * @author Yuri Strot
 * 
 */
public abstract class AbstractViewerDescriptor implements ITextSourceDescriptor {

	protected ITextViewer getTextViewer(Control control) {
		if (control instanceof StyledText) {
			return getTextViewer((StyledText) control);
		}
		return null;
	}

	protected ITextViewer getTextViewer(StyledText text) {
		return ViewerUtils.getTextViewer(text);
	}

}
