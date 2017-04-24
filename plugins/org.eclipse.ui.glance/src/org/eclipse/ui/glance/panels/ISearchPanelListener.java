/**
 * 
 */
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
