/*******************************************************************************
 * Copyright (c) 2017 Exyte
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ivan Lobachev - initial API and implementation
 ******************************************************************************/
package com.xored.glance.ui.ccvs;

import org.eclipse.swt.widgets.Tree;

import com.xored.glance.ui.controls.tree.TreeContent;
import com.xored.glance.ui.controls.tree.TreeStructSource;

public class CVSViewSource extends TreeStructSource {
	public static Tree TREE;

	public CVSViewSource(Tree tree) {
		super(tree);
	}

	@Override
	protected TreeContent createContent() {
		if (CVSViewSource.TREE != null) {
			return new CVSHistorySourceTree(CVSViewSource.TREE);
		}
		return null;
	}

}
