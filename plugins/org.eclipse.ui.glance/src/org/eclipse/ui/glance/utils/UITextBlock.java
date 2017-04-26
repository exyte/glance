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
package org.eclipse.ui.glance.utils;

import org.eclipse.core.runtime.ListenerList;

import org.eclipse.ui.glance.sources.ITextBlock;
import org.eclipse.ui.glance.sources.ITextBlockListener;
import org.eclipse.ui.glance.sources.TextChangedEvent;

/**
 * @author Yuri Strot
 * 
 */
public class UITextBlock implements ITextBlock, ITextBlockListener {

	public UITextBlock(ITextBlock block) {
		this.block = block;
		text = block.getText();
		block.addTextBlockListener(this);
	}

	public void dispose() {
		block.removeTextBlockListener(this);
	}

	/**
	 * @return the block
	 */
	public ITextBlock getBlock() {
		return block;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.glance.sources.ITextBlock#getText()
	 */
	public String getText() {
		return text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.glance.sources.ITextBlock#addTextBlockListener(org.eclipse.ui
	 * .glance.sources.ITextBlockListener)
	 */
	public void addTextBlockListener(ITextBlockListener listener) {
		listeners.add(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.glance.sources.ITextBlock#removeTextBlockListener(org.eclipse.ui
	 * .glance.sources.ITextBlockListener)
	 */
	public void removeTextBlockListener(ITextBlockListener listener) {
		listeners.remove(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.glance.sources.ITextBlockListener#textChanged(org.eclipse.ui.
	 * glance.sources.TextChangedEvent)
	 */
	public void textChanged(TextChangedEvent event) {
		text = block.getText();
		Object[] objects = listeners.getListeners();
		for (Object object : objects) {
			ITextBlockListener listener = (ITextBlockListener) object;
			listener.textChanged(event);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ITextBlock block) {
		return this.block.compareTo(((UITextBlock) block).block);
	}

	@Override
	public String toString() {
		return "UI(" + block + ")";
	}

	private ListenerList listeners = new ListenerList();
	private ITextBlock block;
	private String text;

}
