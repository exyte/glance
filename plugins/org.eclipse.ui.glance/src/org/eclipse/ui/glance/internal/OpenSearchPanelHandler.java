/**
 * 
 */
package org.eclipse.ui.glance.internal;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import org.eclipse.ui.glance.internal.search.SearchManager;

/**
 * @author Yuri Strot
 * 
 */
public class OpenSearchPanelHandler extends AbstractHandler {

	/**
	 * The constructor.
	 */
	public OpenSearchPanelHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		SearchManager.getIntance().activate();
		return null;
	}
}
