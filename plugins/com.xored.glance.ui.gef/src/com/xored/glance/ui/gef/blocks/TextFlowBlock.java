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

import org.eclipse.draw2d.text.TextFlow;

import com.xored.glance.ui.sources.ITextBlock;

public class TextFlowBlock extends FigureTextBlock<TextFlow> {

    public TextFlowBlock(final TextFlow flow) {
        super(flow);
    }

    public String getText() {
        return getFigure().getText();
    }

    public int compareTo(final ITextBlock o) {
        return -1;
    }
}
