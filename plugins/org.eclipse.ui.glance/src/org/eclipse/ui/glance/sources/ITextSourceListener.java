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
package org.eclipse.ui.glance.sources;

/**
 * @author Yuri Strot
 * 
 */
public interface ITextSourceListener {

	/**
	 * Notification about block changing
	 * 
	 * @param removed
	 * @param added
	 */
	public void blocksChanged(ITextBlock[] removed, ITextBlock[] added);

	/**
	 * Notification about all blocks removed and added abother blocks
	 * 
	 * @param newBlocks
	 */
	public void blocksReplaced(ITextBlock[] newBlocks);

	/**
	 * Notification about selection changing
	 * 
	 * @param selection
	 */
	public void selectionChanged(SourceSelection selection);

}
