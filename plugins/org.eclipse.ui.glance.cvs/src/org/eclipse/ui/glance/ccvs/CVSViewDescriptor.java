/*******************************************************************************
 * Copyright (c) 2012 Ivan Lobachev
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ivan Lobachev - initial API and implementation
 ******************************************************************************/
package org.eclipse.ui.glance.ccvs;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.team.internal.ccvs.core.resources.RemoteFolder;
import org.eclipse.team.internal.ccvs.ui.model.AllRootsElement;

import org.eclipse.ui.glance.sources.ITextSource;
import org.eclipse.ui.glance.sources.ITextSourceDescriptor;

@SuppressWarnings("restriction")
public class CVSViewDescriptor implements ITextSourceDescriptor {

	public CVSViewDescriptor() {
	}

	public ITextSource createSource(Control control) {
		if (control != null) {
			CVSViewSource.TREE = (Tree) control;
			return new CVSViewSource((Tree) control);
		}
		return null;
	}

	public boolean isValid(Control control) {
		if (control instanceof Tree
				&& (control.getData() instanceof AllRootsElement || control
						.getData() instanceof RemoteFolder)) {
			return true;
		}
		return false;
	}

}
