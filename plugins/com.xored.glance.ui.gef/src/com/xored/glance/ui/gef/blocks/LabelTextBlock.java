/*******************************************************************************
 * Copyright (c) 2017 Exyte
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Igor Zapletnev - initial API and implementation
 ******************************************************************************/
package com.xored.glance.ui.gef.blocks;

import org.eclipse.draw2d.Label;

import com.xored.glance.ui.sources.ITextBlock;

public class LabelTextBlock extends FigureTextBlock<Label> {

    public LabelTextBlock(final Label label) {
        super(label);
    }

    public String getText() {
        return getFigure().getText();
    }

    public int compareTo(final ITextBlock other) {
        return -1;
    }
}
