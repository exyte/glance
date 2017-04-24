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
package org.eclipse.ui.glance.internal;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.PlatformUI;

import org.eclipse.ui.glance.internal.preferences.IPreferenceConstants;
import org.eclipse.ui.glance.internal.search.SearchManager;

public class GlanceStartup implements IStartup, IPreferenceConstants {

	public void earlyStartup() {
		IPreferenceStore store = GlancePlugin.getDefault().getPreferenceStore();
		if (store.getBoolean(PANEL_STARTUP)) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					SearchManager.getIntance().startup();
				}
			});
		}
	}
}
