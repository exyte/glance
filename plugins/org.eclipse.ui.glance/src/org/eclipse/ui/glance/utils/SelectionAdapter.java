/******************************************************************************* 
 * Copyright (c) 2017 Exyte  
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html  
 * 
 * Contributors: 
 *     Yuri Strot - initial API and Implementation 
 *******************************************************************************/
package org.eclipse.ui.glance.utils;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * @author Yuri Strot
 * 
 */
public abstract class SelectionAdapter implements SelectionListener {

	public final void widgetDefaultSelected(SelectionEvent e) {
		selected(e);
	}

	public final void widgetSelected(SelectionEvent e) {
		selected(e);
	}

	public abstract void selected(SelectionEvent e);

}
