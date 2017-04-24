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
package org.eclipse.ui.glance.internal.search;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.ui.glance.panels.ISearchPanel;

public class SearchProgressMonitor implements IProgressMonitor {

	private final ISearchPanel panel;
	private double total = 1;
	private double current;
	private boolean cancel;

	public SearchProgressMonitor(ISearchPanel panel) {
		this.panel = panel;
	}

	public void beginTask(String name, int totalWork) {
		total = totalWork;
		panel.newTask(name);
		current = 0;
	}

	public void done() {
		if (isCanceled()) {
			return;
		}
		panel.setIndexingState(ISearchPanel.INDEXING_STATE_FINISHED);
	}

	public void internalWorked(double work) {
		if (isCanceled()) {
			return;
		}
		current += work / total;
		if (current > 1) {
			current = 1;
		}
		panel.updateIndexingPercent(current);
	}

	public boolean isCanceled() {
		return cancel || panel.getControl().isDisposed();
	}

	public void setCanceled(boolean value) {
		this.cancel = value;
		panel.setIndexingState(ISearchPanel.INDEXING_STATE_FINISHED);
	}

	public void setTaskName(String name) {
	}

	public void subTask(String name) {
	}

	public void worked(int work) {
		internalWorked(work);
	}

}
