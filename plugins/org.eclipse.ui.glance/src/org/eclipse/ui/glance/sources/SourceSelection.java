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
public class SourceSelection {

	public SourceSelection(ITextBlock block, int offset, int length) {
		this.block = block;
		this.offset = offset;
		this.length = length;
	}

	/**
	 * @return the block
	 */
	public ITextBlock getBlock() {
		return block;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	@Override
	public String toString() {
		return block + ": (" + offset + ", " + length + ")";
	}

	private ITextBlock block;
	private int offset;
	private int length;

}
