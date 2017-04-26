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

import org.eclipse.swt.widgets.Control;

import org.eclipse.ui.glance.sources.ITextSource;
import org.eclipse.ui.glance.sources.ITextSourceDescriptor;

/**
 * @author Yuri Strot
 * 
 */
public class TextSourceMaker {

	public TextSourceMaker(ITextSourceDescriptor description, Control control) {
		this.description = description;
		this.control = control;
	}

	public boolean isValid() {
		return description == null ? false : description.isValid(control);
	}

	public ITextSource create() {
		return description == null ? null : description.createSource(control);
	}

	/**
	 * @return the control
	 */
	public Control getControl() {
		return control;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((control == null) ? 0 : control.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextSourceMaker other = (TextSourceMaker) obj;
		if (control == null) {
			if (other.control != null)
				return false;
		} else if (!control.equals(other.control))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	private ITextSourceDescriptor description;
	private Control control;

}
