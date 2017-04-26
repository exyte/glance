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

import org.eclipse.ui.glance.internal.search.SearchRule;

/**
 * @author Yuri Strot
 * 
 */
public interface ISearchPanelListener {

	public void ruleChanged(SearchRule rule);

	public void findNext();

	public void findPrevious();

	public void close();

	public void indexCanceled();

}
