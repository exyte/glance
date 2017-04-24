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
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.widgets.Control;

import org.eclipse.ui.glance.internal.viewers.TextViewerControl;
import org.eclipse.ui.glance.sources.ITextSource;

/**
 * @author Yuri Strot
 * 
 */
public class TextViewerDescriptor extends AbstractViewerDescriptor {

	public boolean isValid(Control control) {
		ITextViewer viewer = getTextViewer(control);
		return viewer instanceof TextViewer && viewer.getDocument() != null;
	}

	public ITextSource createSource(Control control) {
		return new TextViewerControl((TextViewer) getTextViewer(control));
	}
}
