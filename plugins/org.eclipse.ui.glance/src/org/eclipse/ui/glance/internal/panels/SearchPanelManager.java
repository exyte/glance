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
package org.eclipse.ui.glance.internal.panels;

import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchWindow;

import org.eclipse.ui.glance.internal.GlancePlugin;
import org.eclipse.ui.glance.internal.preferences.IPreferenceConstants;
import org.eclipse.ui.glance.panels.ISearchPanel;

/**
 * @author Yuri Strot
 * 
 */
public class SearchPanelManager {

	public static SearchPanelManager getInstance() {
		if (instance == null)
			instance = new SearchPanelManager();
		return instance;
	}

	public ISearchPanel getPanel(Control control) {
		if (showStatusLine()) {
			IWorkbenchWindow window = SearchStatusLine.getWindow(control);
			if (window != null) {
				return SearchStatusLine.getSearchLine(window);
			}
		}
		PopupSearchDialog dialog = new PopupSearchDialog(control);
		dialog.open();
		return dialog;
	}

	private boolean showStatusLine() {
		return GlancePlugin.getDefault().getPreferenceStore().getBoolean(
				IPreferenceConstants.PANEL_STATUS_LINE);
	}

	private static SearchPanelManager instance;

	private SearchPanelManager() {
	}

}
