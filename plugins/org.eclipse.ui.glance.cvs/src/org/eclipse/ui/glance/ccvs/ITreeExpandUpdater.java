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

import org.eclipse.swt.widgets.TreeItem;

public interface ITreeExpandUpdater {
	public void updateOnExpand(TreeItem item);
}
