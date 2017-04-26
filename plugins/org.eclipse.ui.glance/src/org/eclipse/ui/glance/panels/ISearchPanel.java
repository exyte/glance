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
package org.eclipse.ui.glance.panels;

import org.eclipse.swt.widgets.Control;

import org.eclipse.ui.glance.internal.search.ISearchListener;
import org.eclipse.ui.glance.internal.search.SearchRule;

/**
 * @author Yuri Strot
 * 
 */
public interface ISearchPanel extends ISearchListener {

	public static int INDEXING_STATE_DISABLE = 0;

	public static int INDEXING_STATE_INITIAL = 1;

	public static int INDEXING_STATE_IN_PROGRESS = 2;

	public static int INDEXING_STATE_FINISHED = 3;

	public void addPanelListener(ISearchPanelListener listener);

	public void removePanelListener(ISearchPanelListener listener);

	public void setEnabled(boolean enabled);

	public boolean isApplicable(Control control);

	public Control getControl();

	public void setIndexingState(int state);

	public void updateIndexingPercent(double percent);

	public void newTask(String name);

	/**
	 * Set focus to search panel with some initial text
	 */
	public void setFocus(String text);

	public SearchRule getRule();

	public void closePanel();

	public void findNext();

	public void findPrevious();

	public void clearHistory();
}
