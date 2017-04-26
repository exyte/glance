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
package org.eclipse.ui.glance.internal.sources;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;

import org.eclipse.ui.glance.sources.ITextSourceDescriptor;

/**
 * @author Yuri Strot
 * 
 */
public class TextSourceListener implements Listener {

	public TextSourceListener(ITextSourceDescriptor[] descriptors) {
		this.descriptors = descriptors;
	}

	public void addSourceProviderListener(ISourceProviderListener listener) {
		if (listeners.size() == 0) {
			getDisplay().addFilter(SWT.FocusIn, this);
		}
		listeners.add(listener);
	}

	public void removeSourceProviderListener(ISourceProviderListener listener) {
		listeners.remove(listener);
		if (listeners.size() == 0) {
			getDisplay().removeFilter(SWT.FocusIn, this);
			selection = null;
		}
	}

	public void handleEvent(Event event) {
		TextSourceMaker creator = getCreator(getDisplay().getFocusControl());
		if (!creator.equals(selection)) {
			selection = creator;
			Object[] objects = listeners.getListeners();
			for (Object object : objects) {
				ISourceProviderListener listener = (ISourceProviderListener) object;
				listener.sourceChanged(selection);
			}
		}
	}

	public TextSourceMaker getSelection() {
		return getCreator(getDisplay().getFocusControl());
	}

	private TextSourceMaker getCreator(Control control) {
		return new TextSourceMaker(getDescriptor(control), control);
	}

	private ITextSourceDescriptor getDescriptor(Control control) {
		if (control != null) {
			for (ITextSourceDescriptor descriptor : descriptors) {
				if (descriptor.isValid(control)) {
					return descriptor;
				}
			}
		}
		return null;
	}

	private Display getDisplay() {
		return PlatformUI.getWorkbench().getDisplay();
	}

	private TextSourceMaker selection;
	private ListenerList listeners = new ListenerList();
	private ITextSourceDescriptor[] descriptors;

}
