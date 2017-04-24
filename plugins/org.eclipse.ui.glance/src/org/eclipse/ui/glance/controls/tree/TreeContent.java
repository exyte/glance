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
package org.eclipse.ui.glance.controls.tree;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ListenerList;

import org.eclipse.ui.glance.controls.decor.IPath;
import org.eclipse.ui.glance.controls.decor.IStructContent;
import org.eclipse.ui.glance.controls.decor.StructCell;
import org.eclipse.ui.glance.sources.ITextBlock;
import org.eclipse.ui.glance.sources.ITextSourceListener;

public abstract class TreeContent extends TreeNode implements IStructContent {

	private ListenerList listeners = new ListenerList();

	public TreeContent() {
		super(null);
		index = new int[0];
	}

	public abstract TreeItemContent getContent(TreeCell cell);

	public abstract void index(IProgressMonitor monitor);

	public void dispose() {
	}

	public final ITextBlock getContent(StructCell cell) {
		return getContent((TreeCell) cell);
	}

	public IPath getPath(ITextBlock block) {
		TreeItemContent content = (TreeItemContent) block;
		return new TreePath(content.getNode());
	}

	public void addListener(ITextSourceListener listener) {
		listeners.add(listener);
	}

	public void removeListener(ITextSourceListener listener) {
		listeners.remove(listener);
	}

	public ITextSourceListener[] getListeners() {
		Object[] objects = listeners.getListeners();
		ITextSourceListener[] listeners = new ITextSourceListener[objects.length];
		System.arraycopy(objects, 0, listeners, 0, objects.length);
		return listeners;
	}

	public ITextBlock[] getBlocks() {
		return blocks.toArray(new TreeItemContent[0]);
	}

	void changed(TreeItemContent[] removed, TreeItemContent[] added) {
		for (TreeItemContent item : removed) {
			blocks.remove(item);
		}
		for (TreeItemContent item : added) {
			blocks.add(item);
		}
		for (ITextSourceListener listener : getListeners()) {
			listener.blocksChanged(removed, added);
		}
	}

	private Set<TreeItemContent> blocks = new HashSet<TreeItemContent>();

}
