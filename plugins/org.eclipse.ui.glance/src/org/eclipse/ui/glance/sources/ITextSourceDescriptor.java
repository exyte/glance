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
package org.eclipse.ui.glance.sources;

import org.eclipse.swt.widgets.Control;

/**
 * @author Yuri Strot
 * 
 */
public interface ITextSourceDescriptor {

	/**
	 * Return a boolean indicating whether text source can be created for this
	 * control
	 * 
	 * @return <code>true</code> if the text source can be created, and
	 *         <code>false</code> otherwise
	 */
	public boolean isValid(Control control);

	/**
	 * Creates text source for specified control
	 * 
	 * @param control
	 * @return
	 */
	public ITextSource createSource(Control control);

}
