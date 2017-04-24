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
package org.eclipse.ui.glance.internal.panels;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;

import org.eclipse.ui.glance.internal.GlancePlugin;

/**
 * @author Yuri Strot
 */
public class CheckAction extends Action {

	public CheckAction(String name, String label) {
		super(label, AS_CHECK_BOX);
		this.name = name;
		setChecked(getStore().getBoolean(name));
	}

	public IPreferenceStore getStore() {
		return GlancePlugin.getDefault().getPreferenceStore();
	}

	@Override
	public void run() {
		getStore().setValue(name, isChecked());
	}

	private String name;
}
