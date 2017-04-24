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
package org.eclipse.ui.glance.sources;

import org.eclipse.ui.glance.internal.GlancePlugin;
import org.eclipse.ui.glance.internal.preferences.IPreferenceConstants;

public final class ConfigurationManager {

	private static ConfigurationManager INSTANCE;

	private ConfigurationManager() {
	}

	public static ConfigurationManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ConfigurationManager();
		}
		return INSTANCE;
	}

	public int getMaxIndexingDepth() {
		return GlancePlugin.getDefault().getPreferenceStore().getInt(
				IPreferenceConstants.PANEL_MAX_INDEXING_DEPTH);
	}
	
	public boolean incremenstalSearch(){
	    return GlancePlugin.getDefault().getPreferenceStore().getBoolean(
            IPreferenceConstants.SEARCH_INCREMENTAL);
	}
}
