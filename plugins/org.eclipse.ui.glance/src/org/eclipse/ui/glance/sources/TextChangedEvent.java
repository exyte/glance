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
public class TextChangedEvent {

	public TextChangedEvent(int start, int length, String replacedText) {
		this.start = start;
		this.length = length;
		this.replacedText = replacedText;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @return the replacedText
	 */
	public String getReplacedText() {
		return replacedText;
	}

	/** start offset of the new text */
	private int start;
	/** length of the new text */
	private int length;
	/** replaced text or empty string if no text was replaced */
	private String replacedText;

}
